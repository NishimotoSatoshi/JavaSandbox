package jp.co.opst.s029817.sandbox.for_secure_visitor;

import java.util.Optional;

import jp.co.opst.s029817.sandbox.for_secure_visitor.entity.LockedNode;

/**
 * セキュアビジター。
 * 
 * <p>
 * ただし、仕様は想像です。
 * </p>
 *
 * @param <T> セキュアビジターがノードを処理した結果の型
 */
public interface SecureVisitor<T> {

	/**
	 * ロックされているノードをユーザー権限でアンロックしてから処理します。
	 * 
	 * @param locked ロックされているノード
	 * @param credentials ユーザー権限
	 * @return 処理結果（アンロックに失敗した場合はエンプティ）
	 */
	public default Optional<T> visit(LockedNode locked, UserCredentials credentials) {
		return locked.unlock(credentials).map(unlocked -> visit(unlocked));
	}

	/**
	 * アンロックしたノードを処理します。
	 * 
	 * @param unlocked アンロックされたノード
	 * @return 処理結果
	 */
	public T visit(LockedNode.UnlockedNode unlocked);
}

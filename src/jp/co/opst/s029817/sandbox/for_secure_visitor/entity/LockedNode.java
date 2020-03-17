package jp.co.opst.s029817.sandbox.for_secure_visitor.entity;

import java.util.Optional;

import jp.co.opst.s029817.sandbox.for_secure_visitor.UserCredentials;
import jp.co.opst.s029817.sandbox.for_secure_visitor.SecureVisitor;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * アンロックしなければ参照できないノード。
 */
@AllArgsConstructor
public final class LockedNode {

	/** アンロックに必要な権限レベル。 */
	private final int level;

	/** 名前。 */
	private final String name;

	/**
	 * アンロックされたノード。
	 */
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	public final class UnlockedNode {

		/**
		 * 名前を取得する。
		 * 
		 * @return 名前
		 */
		public String getName() {
			return name;
		}

		/**
		 * セキュアビジターを受け入れます。
		 * 
		 * @param <T> セキュアビジターがノードを処理した結果の型
		 * @param visitor セキュアビジター
		 * @return セキュアビジターがノードを処理した結果
		 */
		public <T> T accept(SecureVisitor<T> visitor) {
			return visitor.visit(this);
		}
	}

	/**
	 * セキュアビジターを受け入れます。
	 * 
	 * @param <T> セキュアビジターがノードを処理した結果の型
	 * @param visitor セキュアビジター
	 * @param credentials ユーザー権限
	 * @return セキュアビジターがノードを処理した結果
	 */
	public <T> Optional<T> accept(SecureVisitor<T> visitor, UserCredentials credentials) {
		return visitor.visit(this, credentials);
	}

	/**
	 * ノードをアンロックします。
	 * 
	 * @param credentials ユーザー権限
	 * @return アンロックされたノード（アンロックに失敗した場合はエンプティ）
	 */
	public Optional<UnlockedNode> unlock(UserCredentials credentials) {
		return Optional.of(new UnlockedNode()).filter(v -> credentials.getLevel() >= level);
	}
}

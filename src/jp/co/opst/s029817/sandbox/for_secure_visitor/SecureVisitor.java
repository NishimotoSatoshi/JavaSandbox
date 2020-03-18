package jp.co.opst.s029817.sandbox.for_secure_visitor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import jp.co.opst.s029817.sandbox.for_secure_visitor.entity.Credentials;
import jp.co.opst.s029817.sandbox.for_secure_visitor.entity.TopEntity;
import jp.co.opst.s029817.sandbox.for_secure_visitor.entity.UserEntity;

/**
 * セキュアビジター。
 * 
 * <p>
 * ただし、このセキュアビジターの仕様は想像です。
 * </p>
 *
 * @param <T> セキュアビジターが処理した結果の型
 */
public interface SecureVisitor<T> {

	/**
	 * セキュリティで守られているユーザー情報を処理します。
	 * 
	 * @param entities ユーザー情報を持つエンティティのリスト
	 * @param credentials ユーザー情報にアクセスするための権限情報
	 * @return 処理結果（ユーザー情報にアクセスできなかったエンティティは含まれない）
	 */
	default List<T> visitUser(List<TopEntity> entities) {
		return entities.stream()
				.map(top -> visitUser(top))
				.filter(Optional::isPresent)
				.map(Optional::get)
				.collect(Collectors.toList());
	}

	/**
	 * 権限情報を取得します。
	 * 
	 * @return 権限情報
	 */
	Credentials getCredentials();

	/**
	 * エンティティからユーザー情報を取得して処理します。
	 * 
	 * @param entity エンティティ
	 * @return 処理結果
	 */
	default Optional<T> visitUser(TopEntity entity) {
		return entity.getUser(getCredentials()).map(user -> visit(user));
	}

	/**
	 * エンティティを処理します。
	 * 
	 * @param entity エンティティ
	 * @return 処理結果
	 */
	default Optional<T> visit(TopEntity entity) {
		throw new UnsupportedOperationException();
	}

	/**
	 * ユーザー情報を処理します。
	 * 
	 * @param user ユーザー情報
	 * @return 処理結果
	 */
	default T visit(UserEntity user) {
		throw new UnsupportedOperationException();
	}
}

package jp.co.opst.s029817.sandbox.for_secure_visitor.core;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import jp.co.opst.s029817.sandbox.for_secure_visitor.entity.Credentials;
import jp.co.opst.s029817.sandbox.for_secure_visitor.entity.TopEntity;
import jp.co.opst.s029817.sandbox.for_secure_visitor.entity.UserEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * セキュアビジターの基底クラス。
 * 
 * @param <T> セキュアビジターが処理した結果の型
 */
@RequiredArgsConstructor
public abstract class SecureVisitorBase<T> {

	/** 権限情報。 */
	@Getter private final Credentials credentials;

	/**
	 * エンティティを処理します。
	 * 
	 * @param entities エンティティのリスト
	 * @return 処理結果
	 */
	public final List<T> visit(List<TopEntity> entities) {
		return entities.stream()
				.map(top -> visit(top))
				.collect(Collectors.toList());
	}

	/**
	 * エンティティを処理します。
	 * 
	 * @param entity エンティティ
	 * @return 処理結果
	 */
	public T visit(TopEntity entity) {
		throw new UnsupportedOperationException();
	}

	/**
	 * ユーザー情報を処理します。
	 * 
	 * @param entities ユーザー情報を持つエンティティのリスト
	 * @param credentials ユーザー情報を取得するための権限情報
	 * @return 処理結果（ユーザー情報が取得できなかったエンティティは含まれない）
	 */
	public final List<T> visitUser(List<TopEntity> entities) {
		return entities.stream()
				.map(top -> visitUser(top))
				.filter(Optional::isPresent)
				.map(Optional::get)
				.collect(Collectors.toList());
	}

	/**
	 * エンティティからユーザー情報を取得して処理します。
	 * 
	 * @param entity エンティティ
	 * @return 処理結果
	 */
	public final Optional<T> visitUser(TopEntity entity) {
		return entity.getUser(getCredentials()).map(user -> visit(user));
	}

	/**
	 * ユーザー情報を処理します。
	 * 
	 * @param user ユーザー情報
	 * @return 処理結果
	 */
	public T visit(UserEntity user) {
		throw new UnsupportedOperationException();
	}
}

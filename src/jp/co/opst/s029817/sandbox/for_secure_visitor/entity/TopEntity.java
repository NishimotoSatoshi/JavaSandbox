package jp.co.opst.s029817.sandbox.for_secure_visitor.entity;

import java.util.Optional;

import jp.co.opst.s029817.sandbox.for_secure_visitor.core.Strongbox;

/**
 * セキュアビジターで扱うエンティティ。
 * 
 * @see Credentials
 * @see UserEntity
 */
public final class TopEntity {

	/** ユーザー情報。 */
	private final Strongbox<UserEntity, Credentials> userEntity;

	/**
	 * コンストラクタ。
	 * 
	 * @param userEntity ユーザー情報
	 */
	public TopEntity(UserEntity userEntity) {
		this.userEntity = new Strongbox<>(userEntity, (v, c) -> v.getLevel() <= c.getLevel());
	}

	/**
	 * ユーザー情報を取得します。
	 * 
	 * @param credentials ユーザー情報を取得する為の権限情報
	 * @return ユーザー情報（権限がなかった場合はエンプティ）
	 */
	public Optional<UserEntity> getUser(Credentials credentials) {
		return userEntity.unlock(credentials);
	}
}

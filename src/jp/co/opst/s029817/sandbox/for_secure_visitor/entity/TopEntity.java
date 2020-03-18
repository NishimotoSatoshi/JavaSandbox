package jp.co.opst.s029817.sandbox.for_secure_visitor.entity;

import java.util.Optional;

import lombok.AllArgsConstructor;

/**
 * セキュアビジターで扱うエンティティ。
 * 
 * @see Credentials
 * @see UserEntity
 */
@AllArgsConstructor
public final class TopEntity {

	/** ユーザー情報の取得に必要な権限レベル。 */
	private final int level;

	/** ユーザー情報。 */
	private final UserEntity user;

	/**
	 * ユーザー情報を取得します。
	 * 
	 * @param credentials ユーザー情報を取得する為の権限情報
	 * @return ユーザー情報（権限がなかった場合はエンプティ）
	 */
	public Optional<UserEntity> getUser(Credentials credentials) {
		return Optional.of(user).filter(v -> credentials.getLevel() >= level);
	}
}

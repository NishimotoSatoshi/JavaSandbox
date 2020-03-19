package jp.co.opst.s029817.sandbox.for_secure_visitor.entity;

import lombok.Value;

/**
 * ユーザー情報。
 * 
 * @see TopEntity
 */
@Value
public final class UserEntity {

	/** アクセスに必要な権限レベル。 */
	private final int level;

	/** 名前。 */
	private final String name;
}

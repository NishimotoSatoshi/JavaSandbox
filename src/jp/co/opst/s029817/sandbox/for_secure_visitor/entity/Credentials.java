package jp.co.opst.s029817.sandbox.for_secure_visitor.entity;

import lombok.Value;

/**
 * 権限情報。
 * 
 * @see TopEntity
 */
@Value
public class Credentials {

	/** 権限レベル。 */
	private final int level;
}

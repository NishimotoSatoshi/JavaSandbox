package jp.co.opst.s029817.sandbox.for_secure_visitor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 架空のユーザー権限です。
 */
@RequiredArgsConstructor
public class UserCredentials {

	/** 権限レベル。 */
	@Getter private final int level;
}

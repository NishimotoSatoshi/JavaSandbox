package jp.co.opst.s029817.sandbox.for_secure_visitor.visitor;

import jp.co.opst.s029817.sandbox.for_secure_visitor.core.SecureVisitorBase;
import jp.co.opst.s029817.sandbox.for_secure_visitor.entity.Credentials;
import jp.co.opst.s029817.sandbox.for_secure_visitor.entity.UserEntity;

/**
 * アクセス可能なユーザー情報を取得するセキュアビジター。
 */
public class AccessableUserCollectVisitor extends SecureVisitorBase<UserEntity> {

	public AccessableUserCollectVisitor(Credentials credentials) {
		super(credentials);
	}

	@Override
	public UserEntity visit(UserEntity user) {
		return user;
	}
}

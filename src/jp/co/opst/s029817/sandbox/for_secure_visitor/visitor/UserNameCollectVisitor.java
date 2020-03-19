package jp.co.opst.s029817.sandbox.for_secure_visitor.visitor;

import jp.co.opst.s029817.sandbox.for_secure_visitor.core.SecureVisitorBase;
import jp.co.opst.s029817.sandbox.for_secure_visitor.entity.Credentials;
import jp.co.opst.s029817.sandbox.for_secure_visitor.entity.UserEntity;

/**
 * ユーザーの名前を取得するセキュアビジター。
 */
public class UserNameCollectVisitor extends SecureVisitorBase<String> {

	public UserNameCollectVisitor(Credentials credentials) {
		super(credentials);
	}

	@Override
	public String visit(UserEntity userEntity) {
		return userEntity.getName();
	}
}

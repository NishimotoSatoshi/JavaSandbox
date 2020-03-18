package jp.co.opst.s029817.sandbox.for_secure_visitor.visitor;

import jp.co.opst.s029817.sandbox.for_secure_visitor.SecureVisitor;
import jp.co.opst.s029817.sandbox.for_secure_visitor.entity.Credentials;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * セキュアビジターの基底クラス。
 * 
 * @param <T> セキュアビジターが処理した結果の型
 */
@RequiredArgsConstructor
public abstract class SecureVisitorBase<T> implements SecureVisitor<T> {

	/** 権限情報。 */
	@Getter private final Credentials credentials;
}

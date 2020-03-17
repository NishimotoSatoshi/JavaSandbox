package jp.co.opst.s029817.sandbox.for_secure_visitor.visitor;

import jp.co.opst.s029817.sandbox.for_secure_visitor.SecureVisitor;
import jp.co.opst.s029817.sandbox.for_secure_visitor.entity.LockedNode;

/**
 * ノードの名前を取得するセキュアビジター。
 */
public class NameCollectVisitor implements SecureVisitor<String> {

	@Override
	public String visit(LockedNode.UnlockedNode unlocked) {
		return unlocked.getName();
	}
}

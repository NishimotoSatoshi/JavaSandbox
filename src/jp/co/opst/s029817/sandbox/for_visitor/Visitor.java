package jp.co.opst.s029817.sandbox.for_visitor;

import jp.co.opst.s029817.sandbox.for_visitor.entity.Entity1;
import jp.co.opst.s029817.sandbox.for_visitor.entity.Entity2;
import jp.co.opst.s029817.sandbox.for_visitor.entity.Entity3;

public interface Visitor {

	void visit(Entity1 entity);
	void visit(Entity2 entity);
	void visit(Entity3 entity);
}

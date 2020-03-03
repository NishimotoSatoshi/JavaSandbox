package jp.co.opst.s029817.sandbox.for_visitor.visitor;

import jp.co.opst.s029817.sandbox.for_visitor.Visitor;
import jp.co.opst.s029817.sandbox.for_visitor.entity.Entity1;
import jp.co.opst.s029817.sandbox.for_visitor.entity.Entity2;
import jp.co.opst.s029817.sandbox.for_visitor.entity.Entity3;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ToStringVisitor implements Visitor<String> {

	@Override
	public String visit(Entity1 entity) {
		return String.format("{ a:%d }", entity.getA());
	}

	@Override
	public String visit(Entity2 entity) {
		return String.format("{ a:%d, b:%s }", entity.getA(), entity.getB());
	}

	@Override
	public String visit(Entity3 entity) {
		return String.format("{ a:%d, b:%s, c:%s }", entity.getA(), entity.getB(), entity.isC());
	}
}

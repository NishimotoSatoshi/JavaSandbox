package jp.co.opst.s029817.sandbox.for_visitor.visitor;

import java.util.ArrayList;
import java.util.List;

import jp.co.opst.s029817.sandbox.for_visitor.Visitor;
import jp.co.opst.s029817.sandbox.for_visitor.entity.Entity1;
import jp.co.opst.s029817.sandbox.for_visitor.entity.Entity2;
import jp.co.opst.s029817.sandbox.for_visitor.entity.Entity3;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ToStringVisitor implements Visitor {

	@Getter private final List<String> results;

	public ToStringVisitor() {
		this(new ArrayList<String>());
	}

	@Override
	public void visit(Entity1 entity) {
		results.add(String.format("{ a:%d }", entity.getA()));
	}

	@Override
	public void visit(Entity2 entity) {
		results.add(String.format("{ a:%d, b:%s }", entity.getA(), entity.getB()));
	}

	@Override
	public void visit(Entity3 entity) {
		results.add(String.format("{ a:%d, b:%s, c:%s }", entity.getA(), entity.getB(), entity.isC()));
	}
}

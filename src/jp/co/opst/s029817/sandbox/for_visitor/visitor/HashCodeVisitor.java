package jp.co.opst.s029817.sandbox.for_visitor.visitor;

import java.util.Arrays;

import jp.co.opst.s029817.sandbox.for_visitor.Visitor;
import jp.co.opst.s029817.sandbox.for_visitor.entity.Entity1;
import jp.co.opst.s029817.sandbox.for_visitor.entity.Entity2;
import jp.co.opst.s029817.sandbox.for_visitor.entity.Entity3;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HashCodeVisitor implements Visitor<Integer> {

	@Override
	public Integer visit(Entity1 entity) {
		return calculateHashCode(
				Integer.hashCode(entity.getA())
		);
	}

	@Override
	public Integer visit(Entity2 entity) {
		return calculateHashCode(
				Integer.hashCode(entity.getA()),
				entity.getB().hashCode()
		);
	}

	@Override
	public Integer visit(Entity3 entity) {
		return calculateHashCode(
				Integer.hashCode(entity.getA()),
				entity.getB().hashCode(),
				Boolean.hashCode(entity.isC())
		);
	}

	private int calculateHashCode(int... hash) {
		return Arrays.stream(hash).reduce(17, (result, element) -> result * 31 + element);
	}
}

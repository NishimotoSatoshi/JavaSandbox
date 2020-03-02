package jp.co.opst.s029817.sandbox.for_visitor.visitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jp.co.opst.s029817.sandbox.for_visitor.Visitor;
import jp.co.opst.s029817.sandbox.for_visitor.entity.Entity1;
import jp.co.opst.s029817.sandbox.for_visitor.entity.Entity2;
import jp.co.opst.s029817.sandbox.for_visitor.entity.Entity3;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HashCodeVisitor implements Visitor {

	@Getter private final List<Integer> results;

	public HashCodeVisitor() {
		this(new ArrayList<Integer>());
	}

	@Override
	public void visit(Entity1 entity) {
		var hashcode = calculateHashCode(
				Integer.hashCode(entity.getA())
		);

		results.add(hashcode);
	}

	@Override
	public void visit(Entity2 entity) {
		var hashcode = calculateHashCode(
				Integer.hashCode(entity.getA()),
				entity.getB().hashCode()
		);

		results.add(hashcode);
	}

	@Override
	public void visit(Entity3 entity) {
		var hashcode = calculateHashCode(
				Integer.hashCode(entity.getA()),
				entity.getB().hashCode(),
				Boolean.hashCode(entity.isC())
		);

		results.add(hashcode);
	}

	private int calculateHashCode(int... hash) {
		return Arrays.stream(hash).reduce(17, (result, element) -> result * 31 + element);
	}
}

package jp.co.opst.s029817.sandbox.for_visitor.entity;

import jp.co.opst.s029817.sandbox.for_visitor.Visitee;
import jp.co.opst.s029817.sandbox.for_visitor.Visitor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Entity2 implements Visitee {

	@Getter private final int a;
	@Getter private final String b;

	@Override
	public <E> E accept(Visitor<E> visitor) {
		return visitor.visit(this);
	}
}

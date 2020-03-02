package jp.co.opst.s029817.sandbox.for_visitor.entity;

import jp.co.opst.s029817.sandbox.for_visitor.Visitee;
import jp.co.opst.s029817.sandbox.for_visitor.Visitor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Entity3 implements Visitee {

	@Getter private final int a;
	@Getter private final String b;
	@Getter private final boolean c;

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}

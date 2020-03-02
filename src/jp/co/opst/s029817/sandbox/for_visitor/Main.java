package jp.co.opst.s029817.sandbox.for_visitor;

import java.util.ArrayList;
import java.util.List;

import jp.co.opst.s029817.sandbox.for_visitor.entity.Entity1;
import jp.co.opst.s029817.sandbox.for_visitor.entity.Entity2;
import jp.co.opst.s029817.sandbox.for_visitor.entity.Entity3;
import jp.co.opst.s029817.sandbox.for_visitor.visitor.HashCodeVisitor;
import jp.co.opst.s029817.sandbox.for_visitor.visitor.ToStringVisitor;

public class Main {

	public static void main(String[] args) {
		var me = new Main();

		System.out.println("ToStringVisitor");
		me.accept(new ToStringVisitor()).getResults().forEach(System.out::println);
		System.out.println();

		System.out.println("HashCodeVisitor");
		me.accept(new HashCodeVisitor()).getResults().forEach(System.out::println);
		System.out.println();
	}

	private List<Visitee> visities = new ArrayList<>();

	public Main() {
		visities.add(new Entity1(1));
		visities.add(new Entity1(2));
		visities.add(new Entity1(3));
		visities.add(new Entity2(1, "foo"));
		visities.add(new Entity2(2, "bar"));
		visities.add(new Entity2(3, "baz"));
		visities.add(new Entity3(1, "foo", true));
		visities.add(new Entity3(2, "bar", false));
		visities.add(new Entity3(3, "baz", true));
	}

	public <E extends Visitor> E accept(E visitor) {
		visities.stream().forEach(e -> e.accept(visitor));
		return visitor;
	}
}

package jp.co.opst.s029817.sandbox.for_visitor;

public interface Visitee {

	<E> E accept(Visitor<E> visitor);
}

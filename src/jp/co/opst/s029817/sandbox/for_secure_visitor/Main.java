package jp.co.opst.s029817.sandbox.for_secure_visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import jp.co.opst.s029817.sandbox.for_secure_visitor.entity.LockedNode;
import jp.co.opst.s029817.sandbox.for_secure_visitor.visitor.NameCollectVisitor;

/**
 * Secure Visitorパターンの演習。
 * 
 * <p>
 * ただし、Secure Visitorパターンの仕様は想像です。
 * </p>
 */
public class Main {

	public static void main(String[] args) {
		var me = new Main();
		me.visit(new NameCollectVisitor(), new UserCredentials(3)).forEach(System.out::println);
	}

	private final List<LockedNode> nodeList = new ArrayList<>();

	public Main() {
		nodeList.add(new LockedNode(1, "name1"));
		nodeList.add(new LockedNode(2, "name2"));
		nodeList.add(new LockedNode(3, "name3"));
		nodeList.add(new LockedNode(4, "name4"));
		nodeList.add(new LockedNode(5, "name5"));
	}

	public <T> List<T> visit(SecureVisitor<T> visitor, UserCredentials credentials) {
		return nodeList.stream()
				.map(locked -> visitor.visit(locked, credentials))
				.filter(Optional::isPresent)
				.map(Optional::get)
				.collect(Collectors.toList());
	}
}

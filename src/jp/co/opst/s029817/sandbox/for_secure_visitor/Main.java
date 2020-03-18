package jp.co.opst.s029817.sandbox.for_secure_visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jp.co.opst.s029817.sandbox.for_secure_visitor.entity.Credentials;
import jp.co.opst.s029817.sandbox.for_secure_visitor.entity.TopEntity;
import jp.co.opst.s029817.sandbox.for_secure_visitor.entity.UserEntity;
import jp.co.opst.s029817.sandbox.for_secure_visitor.visitor.AccessableUserCollectVisitor;
import jp.co.opst.s029817.sandbox.for_secure_visitor.visitor.UserNameCollectVisitor;

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

		new UserNameCollectVisitor(new Credentials(3))
				.visitUser(me.nodeList)
				.forEach(System.out::println);

		new AccessableUserCollectVisitor(new Credentials(4))
				.visitUser(me.nodeList)
				.forEach(user -> System.out.println(user.getName()));
	}

	private final List<TopEntity> nodeList;

	public Main() {
		var nodeList = new ArrayList<TopEntity>();
		nodeList.add(new TopEntity(1, new UserEntity("name1")));
		nodeList.add(new TopEntity(2, new UserEntity("name2")));
		nodeList.add(new TopEntity(3, new UserEntity("name3")));
		nodeList.add(new TopEntity(4, new UserEntity("name4")));
		nodeList.add(new TopEntity(5, new UserEntity("name5")));
		this.nodeList = Collections.unmodifiableList(nodeList);
	}
}

package jp.co.opst.s029817.sandbox.for_jsm;

import java.io.File;

public final class SetPolicy {

	public static final File READABLE_FILE = new File("c:/work/readable.txt");
	public static final File UNREADABLE_FILE = new File("c:/work/unreadable.txt");

	public static void main(String[] args) throws Exception {
		var me = new SetPolicy();
		me.test(READABLE_FILE);
		me.test(UNREADABLE_FILE);
	}

	public void test(File target) {
		System.out.println(target.getAbsolutePath());

		try {
			System.out.println(target.exists());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

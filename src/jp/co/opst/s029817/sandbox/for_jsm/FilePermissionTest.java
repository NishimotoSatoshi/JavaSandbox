package jp.co.opst.s029817.sandbox.for_jsm;

import java.io.File;

/**
 * ファイルパーミッションの演習。
 * 
 * <p>
 * 読み込んだポリシーファイルに、以下の権限が記述されているものとする。
 * </p>
 * <p>
 * {@code permission java.io.FilePermission "c:/work/readable.txt", "read,write";}
 * </p>
 */
public final class FilePermissionTest {

	public static final File READABLE_FILE_SLASH = new File("c:/work/readable.txt");
	public static final File READABLE_FILE_YEN = new File("c:\\work\\readable.txt");
	public static final File UNREADABLE_FILE_SLASH = new File("c:/work/unreadable.txt");
	public static final File UNREADABLE_FILE_YEN = new File("c:\\work\\unreadable.txt");

	public static void main(String[] args) throws Exception {
		var me = new FilePermissionTest();
		me.test(READABLE_FILE_SLASH);
		me.test(READABLE_FILE_YEN);
		me.test(UNREADABLE_FILE_SLASH);
		me.test(UNREADABLE_FILE_YEN);
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

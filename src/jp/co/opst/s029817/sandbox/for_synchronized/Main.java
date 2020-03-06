package jp.co.opst.s029817.sandbox.for_synchronized;

/**
 * synchronizedの挙動を検証する。
 * 
 * <p>
 * <a href="https://www.jpcert.or.jp/java-rules/lck00-j.html">LCK00-J. 信頼できないコードから使用されるクラスを同期するにはprivate finalロックオブジェクトを使用する</a>
 * のサンプルコードにおいて、
 * {@code public synchronized void changeValue()} が、
 * {@code synchronized (new SomeObject())} によってロックされてしまう、と紹介されているので、
 * 検証してみた。
 * </p>
 */
public class Main {

	public static void main(String[] args) throws Exception {
		var me = new Main();

		// ロックに成功するため、5秒かかる。
		System.out.println("Lock by me.");
		me.test(me);
		System.out.println();

		// ロックに失敗するため、5秒かからない。
		System.out.println("Lock by other instance.");
		me.test(new Main());
	}

	private Runnable runnable = new Runnable() {
		@Override
		public void run() {
			try {
				Thread.sleep(1000L);
				foo();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};

	public void test(Object forLock) throws Exception {
		showTime();

		var thread = new Thread(runnable);
		thread.setDaemon(true);
		thread.start();

		synchronized (forLock) {
			Thread.sleep(5000L);
		}
	
		thread.join();
	}

	public synchronized void foo() {
		showTime();
	}

	public void showTime() {
		System.out.println(System.currentTimeMillis());
	}
}

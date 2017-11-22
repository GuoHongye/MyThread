package my.thread;

/**
 * 通过实现Runnable接口实现多线程
 * @author Administrator
 *
 */
class MyThread1 implements Runnable {
	@Override
	public void run() {
		for (int x = 0; x < 10; x++) {
			System.out.println("hello" + x);
		}

	}
}


public class RunnableDemo {
	public static void main(String[] args) {
		new Thread(new MyThread1()).start();
	}

}

package my.thread;

class MyThread3 implements Runnable{
	private String name ;
	public MyThread3(String name) {
		this.name = name ;
	}

	@Override
	public void run() {
		for(int x = 0;x < 10 ;x ++) {
			System.out.println(this.name + "、x=" + x);
		}
		
	}
	
}
public class Test{
	public static void main(String[] args) {
		new Thread(new MyThread3("线程A")).start();
		new Thread(new MyThread3("线程B")).start();
		new Thread(new MyThread3("线程C")).start();
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
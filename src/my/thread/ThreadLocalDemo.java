package my.thread;

/**
 * ThreadLocal类的用法示例
 * @author Administrator
 */
public class ThreadLocalDemo {
	public static void main(String[] args) throws Exception {
		new Thread(() -> {
			Messages msg = new Messages();
			msg.setMsg("AAAAAAAA");
			MessagesSpace.setMessages(msg);
			MessagesSend.send(); // 引用传递
		}, "发送者A").start();
		new Thread(() -> {
			Messages msg = new Messages();
			msg.setMsg("BBBBBBBB");
			MessagesSpace.setMessages(msg);
			MessagesSend.send(); // 引用传递
		}, "发送者B").start();
		new Thread(() -> {
			Messages msg = new Messages();
			msg.setMsg("CCCCCCC");
			MessagesSpace.setMessages(msg);
			MessagesSend.send(); // 引用传递
		}, "发送者C").start();
	}
}

class Messages {
	private String msg = "www.mldn.cn";

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}

class MessagesSend { // 进行一个消息发送的类
	public static void send() {
		Messages temp = MessagesSpace.getMessages();
		System.out.println("【" + Thread.currentThread().getName() + " - 消息发送】" + temp.getMsg());
	}
}

class MessagesSpace { // 定义一个消息的存储空间
	private static ThreadLocal<Messages> threadLocal = new ThreadLocal<Messages>();

	public static void setMessages(Messages t) {
		threadLocal.set(t);
	}

	public static Messages getMessages() {
		return threadLocal.get();
	}
}

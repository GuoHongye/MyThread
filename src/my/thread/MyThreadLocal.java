package my.thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * ThreadLocal类的用法示例
 * @author Administrator
 */
public class MyThreadLocal<T> {

	private Map<Thread, T> container = Collections.synchronizedMap(new HashMap<Thread, T>()); // 此时 container 是线程安全的map
																								// 这是为什么？

	// set 方法实现
	public void Set(T value) {

		container.put(Thread.currentThread(), value);
	}

	//
	public T get() {
    
		Thread thread = Thread.currentThread();

		T value = container.get(thread);

		if (value == null && !container.containsKey(thread)) {
			value = initialValue();
			container.put(thread, value);
		}

		return value;
	}

	public void remove() {
		container.remove(Thread.currentThread());
	}

	protected T initialValue() {

		return null;
	}

}
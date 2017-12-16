package cn.yongqing.job;

import java.util.concurrent.ThreadFactory;

public class HandlerThreadFactory implements ThreadFactory {
	
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		ZNWUncaughtExceptionHandler uncaughtExceptionHandler = new ZNWUncaughtExceptionHandler();
		t.setUncaughtExceptionHandler(uncaughtExceptionHandler);
		t.setPriority(Thread.MAX_PRIORITY);
		return t;
	}
}

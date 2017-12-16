package cn.yongqing.job;


public class ZNWUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
	
	public void uncaughtException(Thread t, Throwable e) {
		e.printStackTrace();
	}
}

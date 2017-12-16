package cn.yongqing.job;

import java.net.InetAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import cn.yongqing.common.UtilHttpClient;


public class HtmlJob {
	private static HtmlJob job;
	
	private ScheduledExecutorService scheduler;
	
	private boolean isStart;
	
	private String url;
	
	private HtmlJob() {
		HandlerThreadFactory threadFactory = new HandlerThreadFactory();
		scheduler = Executors.newScheduledThreadPool(3, threadFactory);
		try {
			String os = System.getProperty("os.name").toLowerCase();
			String name = InetAddress.getLocalHost().getHostName();
			if (os.indexOf("linux") > -1 && !name.startsWith("ubuntu")) {
				url = "http://www.zhaonengwang.com/text_longLink.action";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static HtmlJob create() {
		if (job == null) {
			job = new HtmlJob();
		}
		return job;
	}
	
	public void job() {
		if (isStart || url == null)
			return;
		isStart = true;
		Runnable beeper = new Runnable() {
			public void run() {
				try {
					System.out.println("urlurlurl " + url);
					UtilHttpClient.create().get(url);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		scheduler.scheduleWithFixedDelay(beeper, 10, 1*60, TimeUnit.SECONDS);
	}
}

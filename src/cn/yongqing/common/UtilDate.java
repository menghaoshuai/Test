package cn.yongqing.common;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>Title: 日期、字符串互转工具类</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: yiyaosou.cc</p>
 * @author 董有红
 * @version 1.0
 */
public class UtilDate {
	
	public static SimpleDateFormat yyyyMMdd;
	
	public static SimpleDateFormat yyyyMMddHHmmss;
	
	public static SimpleDateFormat yyyyMMddChina;
	
	public static SimpleDateFormat yyyyMMddHHmmssChina;
	
	public static SimpleDateFormat HHmmss;
	
	public static SimpleDateFormat MMddChina;
	
	
    /**
     * 把字符串转换为日期
     *
     * @param str 被转换的字符串，格式为yyyy-MM-dd
     * @return 转换后的日期
     */
    public static Date strTrferDate(String str) {
        if (str == null || str.trim().equals(""))
            return null;
        if (yyyyMMdd == null) {
        	yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
        }
        Date date = null;
        try {
            date = yyyyMMdd.parse(str);
        } catch (Exception e) {
            return null;
        }
        return date;
    }
    


    /**
     * 把日期转换为字符串
     *
     * @param date 被转换的日期
     * @return 转换后的字符串，格式为yyyy-MM-dd
     */
    public static String dateTrferStr(Date date) {
        if (date == null)
            return null;
        String str = null;
        if (yyyyMMdd == null) {
        	yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
        }
        try {
            str = yyyyMMdd.format(date);
        } catch (Exception e) {
            return null;
        }
        return str;
    }
    
    /**
     * 把日期转换为字符串
     *
     * @param date 被转换的日期
     * @return 转换后的字符串，格式为yyyy年M月d日
     */
    public static String dateTrferChinaStr(Date date) {
        if (date == null)
            return null;
        String str = null;
        if (yyyyMMddChina == null) {
        	yyyyMMddChina = new SimpleDateFormat("yyyy年M月d日");
        }
        try {
            str = yyyyMMddChina.format(date);
        } catch (Exception e) {
            return null;
        }
        return str;
    }


    /**
     * 把字符串转换为时间戳
     *
     * @param str 被转换的字符串，格式为yyyy-MM-dd HH:mm:ss
     * @return 转换后的时间戳
     */
    public static Timestamp strTrferTimestamp(String str) {
        if (str == null || str.trim().equals(""))
            return null;
        Timestamp stamp = null;
        if (yyyyMMddHHmmss == null) {
        	yyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        try {
            Date date = yyyyMMddHHmmss.parse(str);
            stamp = new Timestamp(date.getTime());
        } catch (Exception e) {
            return null;
        }
        return stamp;
    }
    

    /**
     * 把日期转换为字符串
     *
     * @param date 被转换的日期
     * @return 转换后的字符串，格式为yyyy-MM-dd HH:mm:ss
     */
    public static String timestampTrferStr(Date date) {
        if (date == null)
            return null;
        String str = null;
        if (yyyyMMddHHmmss == null) {
        	yyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        try {
            str = yyyyMMddHHmmss.format(date);
        } catch (Exception e) {
            return null;
        }
        return str;
    }
    
    /**
     * 当天0点0分0秒
     *
     * @return 当天时间
     */
    public static Date currDatetime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
    
    /**
     * 把时间戳转换为字符串
     *
     * @param stamp 被转换的时间戳
     * @return 转换后的字符串，格式为yyyy年M月d日 HH时mm分ss秒
     */
    public static String timestampTrferChinaStr(Timestamp stamp) {
        if (stamp == null)
            return null;
        String str = null;
        if (yyyyMMddHHmmssChina == null) {
        	yyyyMMddHHmmssChina = new SimpleDateFormat("yyyy年M月d日 HH时mm分ss秒");
        }
        try {
            str = yyyyMMddHHmmssChina.format(stamp);
        } catch (Exception e) {
            return null;
        }
        return str;
    }
    
    /**
     * 把时间转换为字符串
     *
     * @param time 被转换的时间
     * @return 转换后的字符串，格式为HH:mm:ss
     */
    public static String timeTrferStr(Time time) {
        if (time == null)
            return null;
        String str = null;
        if (HHmmss == null) {
        	HHmmss = new SimpleDateFormat("HH:mm:ss");
        }
        try {
            str = HHmmss.format(time);
        } catch (Exception e) {
            return null;
        }
        return str;
    }
    
    /**
     * 把字符串转为时间
     *
     * @param str 被转换的字符串，格式为HH:mm:ss
     * @return 转换后的时间
     */
    public static Time strTrferTime(String str) {
        if (str == null || str.trim().equals(""))
            return null;
        Time time = null;
        if (HHmmss == null) {
        	HHmmss = new SimpleDateFormat("HH:mm:ss");
        }
        try {
            Date date = HHmmss.parse(str);
            time = new Time(date.getTime());
        } catch (Exception e) {
            return null;
        }
        return time;
    }


    public static void main(String[] args) throws Exception {
    	
//    	int updateDate = (int)(System.currentTimeMillis()/1000);
//    	System.out.println(updateDate);
    	Calendar calendar = Calendar.getInstance();
    	calendar.set(Calendar.DAY_OF_MONTH, 1);
    	calendar.set(Calendar.HOUR_OF_DAY, 0);
    }
}

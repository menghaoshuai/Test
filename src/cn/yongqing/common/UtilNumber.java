package cn.yongqing.common;

import java.text.NumberFormat;

public class UtilNumber {
	
	private static NumberFormat currencyFormat;

    public static NumberFormat currency() {
    	if (currencyFormat != null) {
    		return currencyFormat;
    	}
    	currencyFormat = NumberFormat.getNumberInstance();
		currencyFormat.setGroupingUsed(false);
		currencyFormat.setMaximumFractionDigits(2);
		currencyFormat.setMinimumFractionDigits(2);
		return currencyFormat;
    }
    
    public static NumberFormat jingzheng() {
    	if (currencyFormat != null) {
    		return currencyFormat;
    	}
    	currencyFormat = NumberFormat.getNumberInstance();
		currencyFormat.setGroupingUsed(false);
		currencyFormat.setMaximumFractionDigits(1);
		currencyFormat.setMinimumFractionDigits(1);
		return currencyFormat;
    }
    
    public static long ipToLong(String ip){
    	long number = 0;
    	try {
    		ip = ip.replaceFirst(",.+", "");
	    	String[] ips = ip.split("\\.");
	    	for (int i=0; i<ips.length; i++) {
	    		int offset = (3-i) * 8;
	    		long add = Long.parseLong(ips[i]);
	    		add = add << offset;
	    		number += add;
	    	}
    	} catch (Exception e) {
    		e.printStackTrace();
    		System.out.println("error ip " + ip);
    		number = 0;
    	}
    	return number;
    }
    
    public static String longToIp(long ip){
        StringBuffer sb = new StringBuffer("");
        for (int i=0; i<4; i++) {
        	if (sb.length() > 0)
        		sb.append(".");
        	if (i == 0) {
        		sb.append(ip >>> 24);
        	} else if (i == 1) {
        		sb.append((ip & 0x00FFFFFF) >>> 16);
        	} else if (i == 2) {
        		sb.append((ip & 0x0000FFFF) >>> 8);
        	} else if (i == 3) {
        		sb.append(ip & 0x000000FF);
        	}
        }
        return sb.toString();
    }
    
    public static double kilometre(double _baidux, double _baiduy, double baidux, double baiduy) {
    	double kilometre = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin((_baiduy-baiduy)*Math.PI/180 / 2), 2) + Math.cos(_baiduy*Math.PI/180) * Math.cos(baiduy*Math.PI/180) * Math.pow(Math.sin((_baidux - baidux)*Math.PI/180 / 2), 2)))*6378.137;
    	return kilometre;
    }

    public static void main(String[] args) throws Exception {
//    	String c = "502c192a352e5d365f3341341f3731321c35323f17301331193c303b613b4e3c273d253e";
//    	String d = "527d4d2c512a282e2236393320340337063262342c351935553b563c1c3b3e3b173c3a3d5b3f";
//    	String b = "5a2c5b2a0a2e1d36463338343e373332223453356235623b3f3c1e3b3d3b0f3c0c3d3a3f";
//    	String a = jieMa("4b615e303736413219322c335d36453f40384d3b30333038273d563c373f");
//    	long c = ipToLong("120.9.207.10");
    	String ip = longToIp(3750969822l);
		System.out.println("linken".hashCode());
		

	}
}

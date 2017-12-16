package cn.yongqing.common;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Hex;

/**
 * <p>Title: 字符加密，解码工具类</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: yiyaosou.cc</p>
 * @author 董有红
 * @version 1.0
 */

public class UtilSecurity {
	/**
	 * md5 加密
	 * @param source 被加密的字符串
	 * @return 加密后的字符串
	 */
	public static String md5(String source) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		char[] charArray = source.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];

		byte[] md5Bytes = md5.digest(byteArray);

		StringBuffer hexValue = new StringBuffer();

		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}

		return hexValue.toString();
	}

	/**
	 * 字符串加码
	 * @param source 被加吗的字符串
	 * @return 加吗后的字符串
	 */
	public static String jiama(String source) {
    	if (UtilCommon.isNull(source))
    		return "";
    	StringBuffer buffer = new StringBuffer();
    	int length = source.length();
    	for (int i=0; i<source.length(); i++) {
    		int c = source.charAt(i);
    		int yihuo = (length-i) ^ 15;
    		c ^= yihuo;
    		int differ = (int)(Math.random()*100);
    		differ *= 256;
    		c += differ;
    		String value = Integer.toHexString(c);
    		while (value.length()<4) {
    			value = "0" + value;
    		}
    		buffer.append(value);
    	}
    	return buffer.toString();
    }
    
	/**
	 * 字符串解码
	 * @param source 被解码的字符串
	 * @return 解码后的字符串
	 */
    public static String jiema(String source) {
    	if (UtilCommon.isNull(source))
    		return "";
    	int length = source.length();
    	if (length%4 != 0) {
    		return "www.yiyaosou.cc";
    	}
    	length = length/4;
    	StringBuffer buffer = new StringBuffer();
    	for (int i=0; i<length; i++) {
    		String sub = source.substring(i*4, (i+1)*4);
    		int value = Integer.parseInt(sub,16);
    		value = value%256;
    		int yihuo = (length-i) ^ 15;
    		value ^= yihuo;
    		if (value < 32 || value >126) {
    			buffer = new StringBuffer("www.ohqly.com");
    			break;
    		}
    		buffer.append((char)value);
    	}
    	return buffer.toString();
    }
    
    public static String hexSHA1(String value) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(value.getBytes("utf-8"));
			byte[] digest = md.digest();
			value = String.valueOf(Hex.encodeHex(digest));
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return value;
	}

	public static void main(String args[]) {
		String pass = "adminylyg";
		pass = md5(pass);
		System.out.println(pass);
	}

}
package cn.yongqing.common;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import sun.misc.BASE64Decoder;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;


/**
 * <p>Title: 澶勭悊 http 鍗忚宸ュ叿绫�/p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: yiyaosou.cc</p>
 * @author 钁ｆ湁绾�
 * @version 1.0
 */

public class UtilHttp {
	
	/** 涓婁紶鍥剧墖鏂囦欢鐩綍 */
	private static String SJYS_IMG = "SJYS_IMG";
	public static File SJYS_IMG_ROOT_FILE = null;
	
	private static String STAFF_USER_KEY = "stallUserKey";
	private static String STAFF_USERINFO_KEY = "userInfo";
	public static String VALIDATE_IMAGE_KEY = "validateImageKey";
	
	static {
		try {
			String os = System.getProperty("os.name").toLowerCase();
			String name = InetAddress.getLocalHost().getHostName();
			if (os.indexOf("linux") == -1 || name.startsWith("ubuntu")) {
				String filename = UtilCommon.getFullPathRelateClass(
						"../../../../../", UtilHttp.class);
				SJYS_IMG_ROOT_FILE = new File(filename);
				SJYS_IMG_ROOT_FILE = new File(SJYS_IMG_ROOT_FILE, SJYS_IMG);
			} else {
				SJYS_IMG_ROOT_FILE = new File("/var/www/znw");
				SJYS_IMG_ROOT_FILE = new File(SJYS_IMG_ROOT_FILE, SJYS_IMG);
			}
			if (!SJYS_IMG_ROOT_FILE.exists()) {
				SJYS_IMG_ROOT_FILE.mkdirs();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
     * 淇濆瓨64浣嶅瓧绗︽枃浠�
     * 
     *
     * @param source 46浣嶆枃浠跺瓧绗︿覆
     * @return 鐢熸垚鐨勬枃浠剁洰褰曞悕
     */
	private static String saveBase64File(String source, boolean small) {
		// 鍓嶅彴鐢熸垚base64鏃讹紝鏄互 ABCDEFWWFE.jpg銆�繖绉嶆牸寮忎紶杩囨潵鐨�.jpg鏄枃浠剁殑鍚庣紑鍚�
		String key = ".";
		int index = source.lastIndexOf(key);
		
		String suffix = source.substring(index); // 鍚庣紑鍚�
		source = source.substring(0, index); // 鏂囦欢鐨勭湡姝ase64鍐呭
		key = "base64,";
		index = source.indexOf(key);
		if (index > -1) {
			source = source.substring(index + key.length());
		}
		// 浜х敓鐨勬枃浠跺悕绉�
		File file = randomFile(suffix, small);
		
		BASE64Decoder decoder = new BASE64Decoder();
		OutputStream out = null;
		try {
			// Base64瑙ｇ爜
			byte[] b = decoder.decodeBuffer(source);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 璋冩暣寮傚父鏁版嵁
					b[i] += 256;
				}
			}
			// 鐢熸垚鏂囦欢
			if (small) {
				BufferedImage image = scale(b, 2, false);
				suffix = suffix.replaceFirst("^\\.", "");
				ImageIO.write(image, suffix, file);// 杈撳嚭鍒版枃浠舵祦 
			} else {
				out = new FileOutputStream(file);
				out.write(b);
				out.flush();
			}
			String filename = file.getCanonicalPath();
			filename = filename.replaceAll("\\\\", "/");
			return filename;
		} catch (IOException e) {
			return null;
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {}
		}
	}
	
	private static BufferedImage scale(byte[] b, int scale, boolean flag) throws IOException  {
		InputStream in = null;
		try {
			in = new ByteInputStream(b, b.length);
			BufferedImage bufferedImage = ImageIO.read(in); // 璇诲叆鏂囦欢
			int width = bufferedImage.getWidth(); // 寰楀埌婧愬浘瀹�
			int height = bufferedImage.getHeight(); // 寰楀埌婧愬浘闀�
			if (flag) {
				// 鏀惧ぇ 
				width = width * scale;
				height = height * scale;
			} else {
				// 缂╁皬
				width = width / scale;
				width = Math.min(105, width);
				height = height / scale;
				height = Math.min(105, height);
			}
			Image image = bufferedImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
			BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 缁樺埗缂╁皬鍚庣殑鍥�  
			g.dispose();  
			return tag;
		} finally {
			if (in != null)
				in.close();
		}
	}
	
	/**
     * 淇濆瓨64浣嶅瓧绗﹀浘鐗囨枃浠�
     * 
     *
     * @param source 46浣嶆枃浠跺瓧绗︿覆
     * @return 鐢熸垚鐨勬枃浠剁洰褰曞悕
     */
	public static String saveBase64ImageFile(String source) {
		if (UtilCommon.isNull(source))
			return null;
		String filename = saveBase64File(source, false);
		filename = filename.replaceFirst(".*/" + SJYS_IMG, "/" + SJYS_IMG);
		return filename;
	}
	
	public static String saveBase64SmallImageFile(String source) {
		if (UtilCommon.isNull(source))
			return null;
		String filename = saveBase64File(source, true);
		filename = filename.replaceFirst(".*/" + SJYS_IMG, "/" + SJYS_IMG);
		return filename;
	}
	
	public static String saveMubiteBase64ImageFile(String source) {
		if (UtilCommon.isNull(source))
			return null;
		String [] imgs = source.split(",");
		StringBuffer names = new StringBuffer();
		for (String img : imgs) {
			if (UtilCommon.isNull(img))
				continue;
			String filename = saveBase64ImageFile(img);
			if (names.length() > 0)
				names.append(",");
			names.append(filename);
		}
		return names.toString();
	}
	
	public static String saveMubiteBase64SmallImageFile(String source) {
		if (UtilCommon.isNull(source))
			return null;
		String [] imgs = source.split(",");
		StringBuffer names = new StringBuffer();
		for (String img : imgs) {
			if (UtilCommon.isNull(img))
				continue;
			String filename = saveBase64SmallImageFile(img);
			if (names.length() > 0)
				names.append(",");
			names.append(filename);
		}
		return names.toString();
	}

	/**
     * 鐢熸垚闅忔満鍚嶅瓧,涓嶉噸澶�
     *
     * @return 闅忔満鏂囦欢鍚�
     */
	public static File randomFile(String suffix, boolean smallFlag) {
		Calendar calendar = Calendar.getInstance();
		String filename = UtilDate.dateTrferStr(calendar.getTime()).replaceAll("-", "_");
		File file = new File(SJYS_IMG_ROOT_FILE, filename);
		if (!file.exists()) {
			file.mkdirs();
		}
		StringBuffer sb = new StringBuffer();
		if (smallFlag)
			sb.append("small");
		sb.append(calendar.getTimeInMillis());
		sb.append("_");
		Random random = new Random();
		sb.append(random.nextInt(100));
		sb.append(random.nextInt(99));
		sb.append("_");
		sb.append(random.nextInt(98));
		sb.append(random.nextInt(97));
		sb.append(suffix);
		file = new File(file, sb.toString());
		return file;
	}
	
	
	
	/**
     * 鎶婇獙璇佸瓧绗︿覆淇濆瓨鍦℉ttp Session閲�
     *
     * @param request http璇锋眰
     * @param zifu 闇�淇濆瓨鐨勫瓧绗�
     */
	public static void saveZifu(HttpServletRequest request, String zifu) {
		HttpSession session = request.getSession();
		session.setAttribute(VALIDATE_IMAGE_KEY, zifu);
	}
	
	/**
     * 鎶婇獙璇佸瓧绗︿覆淇濆瓨鍦℉ttp Session閲�
     *
     * @param zifu 闇�淇濆瓨鐨勫瓧绗�
     */
	public static void saveZifu(String zifu) {
		saveZifu(ServletActionContext.getRequest(), zifu);
	}
	
	/**
     * 浠嶩ttp Session鍙栧緱楠岃瘉瀛楃涓�
     *
     * @return 鍙栧緱鐨勫瓧绗︿覆
     */
	public static String getZifu() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		String zifu = (String)session.getAttribute(VALIDATE_IMAGE_KEY);
		return zifu;
	}
	
	public static String referer() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String referer = request.getHeader("referer");
		if (referer == null)
			referer = request.getHeader("Referer");
		return referer;
	}
	
	public static boolean isIOS() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String agent = request.getHeader("User-Agent");
		if (UtilCommon.isNull(agent))
			return false;
		agent = agent.toLowerCase();
		boolean result = agent.indexOf("iphone") > -1 || agent.indexOf("ios") > -1;
		return result;
	}
	
	public static int getUserCode() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String _userCode = request.getParameter("userCode");
		int userCode = 0;
		if (!UtilCommon.isNull(_userCode) && _userCode.matches("^\\d+$")) {
			userCode = Integer.parseInt(_userCode);
		}
		return userCode;
	}
	
	public static String getToken() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String token = request.getParameter("token");
		return token;
	}
	
	public static void setCookie(String name, String value, int maxAge) {
    	HttpServletResponse response = ServletActionContext.getResponse();
    	setCookie(response, name, value, maxAge);
    }
	
	public static void setCookie(HttpServletResponse response, String name, String value, int maxAge) {
    	if (value == null)
    		return;
    	try {
    		value = URLEncoder.encode(value, "utf-8");
        	Cookie cookie = new Cookie(name, value);
        	cookie.setMaxAge(maxAge);
    		cookie.setPath("/");
    		response.addCookie(cookie);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
	
	public static String getCookie(String key) {
		HttpServletRequest request = ServletActionContext.getRequest();
		return getCookie(request,key);
	}
	
	public static String getCookie(HttpServletRequest request, String key) {
		Cookie[] cookies = request.getCookies();
		String value = null;
		if (cookies != null) {
        	for (int i=0; i<cookies.length; i++) {
        		Cookie cookie = cookies[i];
        		String name = cookie.getName();
        		if (name.equals(key)) {
        			try {
        				value = cookie.getValue();
        				value = URLDecoder.decode(value, "utf-8");
        			} catch (Exception e) {
        				e.printStackTrace();
        			}
        		}
        	}
		}
		return value;
	}
	
	
	public static void main(String[] args) {
		System.out.println(saveBase64ImageFile("sdfsdf.jpg"));
	}
}
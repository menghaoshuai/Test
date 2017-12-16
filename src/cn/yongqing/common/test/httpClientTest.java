package cn.yongqing.common.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * 单元测试 "rong": { "token":
 * "YWW1LDp9QaGq2WCz1FFCs1YDzuSLr437h7VsadzYgXvlwsbrNwNNY3QAkH2B4Fuv/pqnLWzoCVWmLh0PE3A9vA=="
 * , "userId": "14", "code": 200 }
 * 
 * @author suxg
 * 
 */
public class httpClientTest {

	// public static String url = "http://182.92.68.230:8080/YLYG";
	// public static String url = "http://192.168.1.139:8080/YLYG";

	//public static String url = "http://127.0.0.1:8081/qinengwang";
	public static String url = "http://shixin.court.gov.cn/";

	// public static String url = "http://127.0.0.1:80/YLYG";
	public static void main(String[] args) throws Exception, Exception {
		// testRegist();
		// testLogin();
		// testRetrievePassword();
		// testChangePassword();
		// testUserInfoDetails();
		// testChangeUserInfo();
		// testChangePasswordByOldPassword();
		testRegists();
	}

	/**
	 * 自动提交UserInfoAction.regist()
	 */
	public static void testRegists() {
		NameValuePair pName = new NameValuePair("pName", "孟豪帅");
		NameValuePair pCardNum = new NameValuePair("pCardNum", "610481199407173814");
		NameValuePair pProvince = new NameValuePair("pProvince", "66111");
		String path = "/findd";
		NameValuePair[] NameValuePair = new NameValuePair[] { pName,
				pCardNum, pProvince };
		httpClientTest.sendServerData(path, NameValuePair);
	}

	
	/**
	 * 用户注册 UserInfoAction.regist()
	 */
	public static void testRegist() {
		NameValuePair mobile = new NameValuePair("mobile", "18515889095");
		NameValuePair securityCode = new NameValuePair("securityCode", "224741");
		NameValuePair password = new NameValuePair("password", "888888");
		String path = "/userinfo_regist.action";
		NameValuePair[] NameValuePair = new NameValuePair[] { mobile,
				securityCode, password };
		httpClientTest.sendServerData(path, NameValuePair);
	}

	/**
	 * 用户登陆 UserInfoAction.login()
	 */
	public static void testLogin() {
		NameValuePair mobile = new NameValuePair("mobile", "18515889095");
		NameValuePair password = new NameValuePair("password", "888888");
		String path = "/userinfo_login.action";
		NameValuePair[] NameValuePair = new NameValuePair[] { mobile, password };
		httpClientTest.sendServerData(path, NameValuePair);
	}

	/**
	 * 找回密码 UserInfoAction.retrievePassword()
	 */
	public static void testRetrievePassword() {
		NameValuePair mobile = new NameValuePair("mobile", "18515889095");
		NameValuePair securityCode = new NameValuePair("securityCode", "224741");
		String path = "/userinfo_retrievePassword.action";
		NameValuePair[] NameValuePair = new NameValuePair[] { mobile,
				securityCode };
		httpClientTest.sendServerData(path, NameValuePair);
	}

	/**
	 * 更新密码 UserInfoAction.changePassword()
	 */
	public static void testChangePassword() {
		NameValuePair mobile = new NameValuePair("mobile", "15810041123");
		NameValuePair password = new NameValuePair("password", "111111");
		String path = "/userinfo_changePassword.action";
		NameValuePair[] NameValuePair = new NameValuePair[] { mobile, password };
		httpClientTest.sendServerData(path, NameValuePair);
	}

	/**
	 * 用户详情 UserInfoAction.userInfoDetails()
	 */
	public static void testUserInfoDetails() {
		NameValuePair mobile = new NameValuePair("mobile", "18515889095");
		NameValuePair password = new NameValuePair("password", "888888");
		String path = "/userinfo_userInfoDetails.action";
		NameValuePair[] NameValuePair = new NameValuePair[] { mobile, password };
		httpClientTest.sendServerData(path, NameValuePair);
	}
	
	/**
	 * 修改用户数据 UserInfoAction.changeUserInfo()
	 */
	public static void testChangeUserInfo() {
		String headImg1 = "/9j/4AAQSkZJRgABAQAAAAAAAAD/4QCMRXhpZgAATU0AKgAAAAgABQESAAMAAAAB"
				+ "AAEAAAEaAAUAAAABAAAASgEbAAUAAAABAAAAUgEoAAMAAAABAAIAAIdpAAQAAAAB"
				+ "AAAAWgAAAAAAAAAAAAAAAQAAAAAAAAABAAOgAQADAAAAAQABAACgAgAEAAAAAQAA"
				+ "ACSgAwAEAAAAAQAAACQAAAAA/+0AOFBob3Rvc2hvcCAzLjAAOEJJTQQEAAAAAAAA"
				+ "OEJJTQQlAAAAAAAQ1B2M2Y8AsgTpgAmY7PhCfv/AABEIACQAJAMBEQACEQEDEQH/"
				+ "xAAfAAABBQEBAQEBAQAAAAAAAAAAAQIDBAUGBwgJCgv/xAC1EAACAQMDAgQDBQUE"
				+ "BAAAAX0BAgMABBEFEiExQQYTUWEHInEUMoGRoQgjQrHBFVLR8CQzYnKCCQoWFxgZ"
				+ "GiUmJygpKjQ1Njc4OTpDREVGR0hJSlNUVVZXWFlaY2RlZmdoaWpzdHV2d3h5eoOE"
				+ "hYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX"
				+ "2Nna4eLj5OXm5+jp6vHy8/T19vf4+fr/xAAfAQADAQEBAQEBAQEBAAAAAAAAAQID"
				+ "BAUGBwgJCgv/xAC1EQACAQIEBAMEBwUEBAABAncAAQIDEQQFITEGEkFRB2FxEyIy"
				+ "gQgUQpGhscEJIzNS8BVictEKFiQ04SXxFxgZGiYnKCkqNTY3ODk6Q0RFRkdISUpT"
				+ "VFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqCg4SFhoeIiYqSk5SVlpeYmZqio6Slpqeo"
				+ "qaqys7S1tre4ubrCw8TFxsfIycrS09TV1tfY2dri4+Tl5ufo6ery8/T19vf4+fr/"
				+ "2wBDAAEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEB"
				+ "AQEBAQEBAQEBAQEBAQEBAQEBAQH/2wBDAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEB"
				+ "AQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQH/3QAEAAX/"
				+ "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.jpg";
		NameValuePair mobile = new NameValuePair("mobile", "18515889095");
		NameValuePair img = new NameValuePair("img", headImg1);
		String path = "/userinfo_changeHeadImg.action";
		NameValuePair[] NameValuePair = new NameValuePair[] { mobile, img };
		httpClientTest.sendServerData(path, NameValuePair);
	}
	
	/**
	 * 修改密码（根据旧密码） UserInfoAction.changePasswordByOldPassword()
	 */
	public static void testChangePasswordByOldPassword() {
		NameValuePair mobile = new NameValuePair("mobile", "18515889095");
		NameValuePair securityCode = new NameValuePair("oldPassword", "224741");
		String path = "/userinfo_changePasswordByOldPassword.action";
		NameValuePair[] NameValuePair = new NameValuePair[] { mobile,
				securityCode };
		httpClientTest.sendServerData(path, NameValuePair);
	}
	
	/**
	 * 公共发送
	 * 
	 * @param path
	 *            路径
	 * @param NameValuePair
	 *            参数
	 */
	public static void sendServerData(String path, NameValuePair[] NameValuePair) {
		PostMethod method = new PostMethod(url + path);
		try {
			HttpClient client = new HttpClient();
			method.addRequestHeader("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			method.setRequestBody(NameValuePair);
			client.executeMethod(method);
			// 打印服务器返回的状态
			System.out.println(method.getStatusLine());
			// 打印返回的信息
			System.out.println();
			InputStream stream = method.getResponseBodyAsStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					stream, "UTF-8"));
			StringBuffer buf = new StringBuffer();
			String line;
			while (null != (line = br.readLine())) {
				buf.append(line).append("\n");
			}
			System.out.println(buf.toString());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放连接
			method.releaseConnection();
		}
	}
}

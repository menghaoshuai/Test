package cn.yongqing.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

/**
 * <p>Title: http 请求工具类</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: yiyaosou.cc</p>
 * @author 董有红
 * @version 1.0
 */
public class UtilHttpClient {
	private String charset;
	
	private String referer;
	
	private CloseableHttpClient httpclient;
	
	private static UtilHttpClient instance;
	
	private final static String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:26.0) Gecko/20100101 Firefox/26.0";
	
	private UtilHttpClient() {
		RequestConfig globalConfig = RequestConfig.custom().setConnectTimeout(5000).setSocketTimeout(5000).setCookieSpec(CookieSpecs.BROWSER_COMPATIBILITY).build();
        httpclient = HttpClients.custom().setUserAgent(USER_AGENT)
                .addInterceptorFirst(new HttpRequestInterceptor() {
                public void process(
                        final HttpRequest request,
                        final HttpContext context) throws HttpException, IOException {
                    if (!request.containsHeader("Accept-Encoding")) {
                        request.addHeader("Accept-Encoding", "gzip");
                    }

                }}).addInterceptorFirst(new HttpResponseInterceptor() {

                public void process(
                        final HttpResponse response,
                        final HttpContext context) throws HttpException, IOException {
                    HttpEntity entity = response.getEntity();
                    if (entity != null) {
                        Header ceheader = entity.getContentEncoding();
                        if (ceheader != null) {
                            HeaderElement[] codecs = ceheader.getElements();
                            for (int i = 0; i < codecs.length; i++) {
                                if (codecs[i].getName().equalsIgnoreCase("gzip")) {
                                    response.setEntity(
                                            new GzipDecompressingEntity(response.getEntity()));
                                    return;
                                }
                            }
                        }
                    }
                }

            }).setDefaultRequestConfig(globalConfig).build();
        charset = "utf-8";
    }
	
	public static UtilHttpClient create() {
		if (instance == null)
			instance = new UtilHttpClient();
		return instance;
	}
	
	public void setCharset(String charset) {
		this.charset = charset;
	}
	
	public void setReferer(String referer) {
		this.referer = referer;
	}
	
	/**
	 * 通过 url，请求返回值
	 * 
	 * @param url 请求的url
	 * @return Map，statusCode表示http请求返回的状态码，result表示http请求结果
	 */
	public Map<String, String> get(String url) throws IOException {
		HttpGet httpGet = new HttpGet(url);
		String result = null;
		if (!UtilCommon.isNull(referer)) {
			httpGet.addHeader("Referer", referer);
		}
		CloseableHttpResponse response = httpclient.execute(httpGet);
		Map<String, String> map = new HashMap<String, String>();
		try {
			int statusCode = response.getStatusLine().getStatusCode();
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity, charset);
			map.put("statusCode", String.valueOf(statusCode));
			map.put("result", result);
		} finally {
			response.close();
		}
		referer = url;
		return map;
	}
	
	/**
	 * 通过post url，已经请求参数，请求返回值
	 * 
	 * @param url 请求的url
	 * @param map 请求参数
	 * @return Map，statusCode表示http请求返回的状态码，result表示http请求结果
	 */
	public Map<String, String> post(String url, Map<String,?> params, Map<String, String> headers) throws IOException {
		HttpPost httpPost = new HttpPost(url);
		if (headers != null) {
			Iterator<String> it = headers.keySet().iterator();
			while (it.hasNext()) {
				String name = it.next();
				String value = headers.get(name);
				httpPost.addHeader(name, value);
			}
		}
		String result = null;
		if (params == null) {
			params = new HashMap<String, String>();
		}
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		Iterator<String> it = params.keySet().iterator();
		while (it.hasNext()) {
			String name = it.next();
			Object value = params.get(name);
			if (value instanceof String) {
				String _value = value.toString();
				BasicNameValuePair valuePair = new BasicNameValuePair(name, _value);
				nvps.add(valuePair);
			} else if (value instanceof List) {
				@SuppressWarnings("unchecked")
				List<String> list = (List<String>)value;
				for (String _value : list) {
					BasicNameValuePair valuePair = new BasicNameValuePair(name, _value);
					nvps.add(valuePair);
				}
			}
		}
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, charset));
		if (!UtilCommon.isNull(referer)) {
			httpPost.addHeader("Referer", referer);
		}
		CloseableHttpResponse response = httpclient.execute(httpPost);
		Map<String, String> results = new HashMap<String, String>();
		try {
			int statusCode = response.getStatusLine().getStatusCode();
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity, charset);
			results.put("statusCode", String.valueOf(statusCode));
			results.put("result", result);
		} finally {
			response.close();
		}
		referer = url;
		return results;
	}
	
	public Map<String, String> post(String url, Map<String,?> params) throws IOException {
		return post(url, params, null);
	}
	
	public String getString(String url) throws IOException {
		HttpGet httpGet = new HttpGet(url);
		String result = null;
		CloseableHttpResponse response = httpclient.execute(httpGet);
		try {
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				throw new IOException("返回状态出错");
			}
			HttpEntity entity = response.getEntity();
			result = EntityUtils.toString(entity, charset);
		} finally {
			response.close();
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		
	}
}

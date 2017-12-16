package cn.yongqing.common;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MulitStreamResult {

	public static void service(HttpServletRequest request, HttpServletResponse response, byte[] bytes, String contentType) {
		ServletOutputStream out = null;
		try {
			String range = request.getHeader("range");
			if (UtilCommon.isNull(range)) {
				range = request.getHeader("Range");
			}
			response.setContentType(contentType);
			int fileLength = bytes.length;
			if (!UtilCommon.isNull(range)) {
				range = range.replaceFirst("^bytes\\D?", "");
				int past = 0;
				int length = 0;
				String contentRange = null;
				if (range.endsWith("-")) {
					past = Integer.parseInt(range.replaceAll("\\D", ""));
					length = fileLength - past;
					contentRange = "bytes " + past + "-" + length + "/" + fileLength;
				} else {
					past = Integer.parseInt(range.replaceFirst("-.+", "").replaceAll("\\D", ""));
					length = Integer.parseInt(range.replaceFirst(".+-", "").replaceAll("\\D", ""));
					length = length - past + 1;
					contentRange = "bytes " + range + "/" + fileLength;
				}
				response.setHeader("Accept-Ranges", "bytes");
				response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
				response.setHeader("Content-Range", contentRange);
				response.addHeader("Content-Length", String.valueOf(length));
				
				out = response.getOutputStream();
				out.write(bytes, past, length);
				out.flush();
			} else {
				response.setHeader("Content-Length", String.valueOf(fileLength));
				out = response.getOutputStream();
				out.write(bytes);
				out.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static boolean checkHeaderCache(HttpServletRequest request, HttpServletResponse response, long currTime) {
		if (currTime == 0)
			return false;
		long modified = request.getDateHeader("If-Modified-Since");
		if (currTime < modified) {
			// 当前时间小于修改时间
			response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
			return true;
		}
		String _etag = request.getHeader("If-None-Match");
		if (_etag != null && _etag.matches("^\\d+$")) {
			long etag = Long.parseLong(_etag);
			if (etag == currTime) {
				// 没有修改
				response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
				return true;
			}
		}
		response.addDateHeader("Last-Modified", currTime);
		response.setHeader("ETag", String.valueOf(currTime));
		return false;
	}
}

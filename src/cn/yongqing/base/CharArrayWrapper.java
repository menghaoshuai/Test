package cn.yongqing.base;

import java.io.CharArrayWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CharArrayWrapper extends HttpServletResponseWrapper {
	private CharArrayWriter charWriter;

	public CharArrayWrapper(HttpServletResponse response) {
		super(response);
		charWriter = new CharArrayWriter();
	}

	public PrintWriter getWriter() {
		return (new PrintWriter(charWriter));
	}

	public String toString() {
		return (charWriter.toString());
	}

	public char[] toCharArray() {
		return (charWriter.toCharArray());
	}
}

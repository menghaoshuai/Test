package cn.yongqing.common;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UtilPage {
	
	private static Map<Integer, Integer> ROWS_PER_PAGES;
	
	public static int max(int page, int rowsPerPage, List<?> list) {
		if (rowsPerPage == 0)
			rowsPerPage = 15;
		page = Math.max(1, page);
		int index = page*rowsPerPage;
		index = Math.min(index, list.size());
		return index;
	}
	
	public static int min(int page, int rowsPerPage, List<?> list) {
		if (rowsPerPage == 0)
			rowsPerPage = 15;
		--page;
		page = Math.max(0, page);
		int index = page*rowsPerPage;
		index = Math.min(index, list.size());
		return index;
	}
	
	public static int offset(int page, int rowsPerPage) {
		if (rowsPerPage == 0)
			rowsPerPage = 15;
		--page;
		page = Math.max(0, page);
		int index = page*rowsPerPage;
		return index;
	}
	
	public static int length(int rowsPerPage) {
		if (rowsPerPage == 0)
			rowsPerPage = 15;
		return rowsPerPage;
	}
	
	public static Map<Integer, Integer> rowsPerPages() {
		if (ROWS_PER_PAGES == null) {
			ROWS_PER_PAGES = new TreeMap<Integer, Integer>();
			ROWS_PER_PAGES.put(10, 10);
			ROWS_PER_PAGES.put(15, 15);
			ROWS_PER_PAGES.put(20, 20);
			ROWS_PER_PAGES.put(25, 25);
			ROWS_PER_PAGES.put(30, 30);
			ROWS_PER_PAGES.put(35, 35);
			ROWS_PER_PAGES.put(40, 40);
			ROWS_PER_PAGES.put(45, 45);
			ROWS_PER_PAGES.put(50, 50);
		}
		return ROWS_PER_PAGES;
	}
	
}

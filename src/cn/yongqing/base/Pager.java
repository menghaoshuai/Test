package cn.yongqing.base;

import java.util.Map;

import cn.yongqing.common.UtilPage;

public class Pager {

	private int page;
	
	private int nextPage;
	
	private int rowsPerPage;
	
	public int getPage() {
		page = Math.max(1, page);
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRowsPerPage() {
		if (rowsPerPage == 0)
			rowsPerPage = 10;
		return rowsPerPage;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}
	
	public int getNextPage() {
		
		return nextPage;
	}

	public int getPrePage() {
		int prePage = getPage();
		--prePage;
		prePage = Math.max(0, prePage);
		return prePage;
	}
	
	public int getFirPage() {
		int firPage = getPrePage();
		if (firPage < 1)
			return firPage;
		return 1;
	}

	public Map<Integer, Integer> getRowsPerPages() {
		return UtilPage.rowsPerPages();
	}
	
	public void reset(int length) {
		int rowsPerPage = getRowsPerPage();
		if (length < rowsPerPage)
			nextPage = 0;
		else
			nextPage = getPage() + 1;
	}

}

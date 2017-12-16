package cn.yongqing.base;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;

import cn.yongqing.common.UtilDate;
 

/**
 * <p>Title: 基础实体类</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: </p>
 * @author 董有红
 * @version 1.0
 */

public class Base implements Serializable, Comparable<Base> {
	
	private static final long serialVersionUID = -3387516993124229949L;
	
	/** 实体Code */
    private int code;
	
    /** 实体排序用 */
    private int sort;
    
    /** 分页处理 */
    private Pager pager;
    
    /** app 用总数 */
	private int total;
	
	/** 当前页 app用 */
	private short page;
	
	/** 每页展示数 app用 */
	private short rowsPerPage;
    
    public Base() {
    	pager = new Pager();
    }
    
	public int compareTo(Base other) {
		int thisSort = getSort();
		int otherSort = other.getSort();
		int differ = thisSort - otherSort;
		int result = (int)Math.signum(differ);
		return result;
	}

	public int getSort() {
		return sort;
	}


	public void setSort(int sort) {
		this.sort = sort;
	}


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}
	
	
	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	/**
     * 重写Object toString 方法，把对象转换为json数据格式
     *
     * @return 对象转换后的json数据格式
     */
	public String toString() {
		StringBuffer buffer = new StringBuffer();
        try {
            Method[] methods = this.getClass().getMethods();
            for (Method method : methods) {
                String name = method.getName();
                if (!name.matches("^get[A-Z].*$")) {
                    continue;
                } else if (name.equals("getClass")) {
                	continue;
                } else if (name.equals("getSort") || name.equals("getPager") || name.equals("getOperMenus") || name.equals("getPassword")) {
                	continue;
                } 
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length != 0)
                    continue;
                Class<?> returnType = method.getReturnType();
                if (returnType.toString().equals("void"))
                    continue;
                Object obj = method.invoke(this, new Object[] {});
                name = name.substring(3, 4).toLowerCase() + name.substring(4);
                if (buffer.length() > 0)
                    buffer.append(", ");
                
                if (obj == null) {
                    buffer.append("\"" + name + "\":\"\"");
                } else {
                	String value = null;
                	if (obj instanceof String) {
                		value = obj.toString().trim();
                		if (!value.matches("^[\\{\\[][\\s\\S]*[\\}\\]]$")) {
                			value = value.replaceAll("[\"\\[\\]\\{\\}\t\r\n]", "");
                			value = value.replaceAll("&nbsp;", "");
                		}
                	} else if (obj instanceof String[]) {
                		StringBuffer _buffer = new StringBuffer();
                		String[] objs = (String[])obj;
                		for (String _value : objs) {
                			if (_buffer.length() > 0)
                				_buffer.append(",");
                			_buffer.append("\"" + _value + "\"");
                		}
                		_buffer.insert(0, "[");
                		_buffer.append("]");
                		value = _buffer.toString();
                	} else if (obj instanceof Timestamp) {
                		Timestamp _obj = (Timestamp)obj;
                		value = UtilDate.timestampTrferStr(_obj);
                	} else if (obj instanceof Date) {
                		Date _obj = (Date)obj;
                		value = UtilDate.dateTrferStr(_obj);
                	} else {
                		value = obj.toString();
                	}
                    buffer.append("\"" + name + "\":\"" + value + "\"");
                } 
            }
            buffer.insert(0, "{");
            buffer.append("}");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String result = buffer.toString();
        result = result.replaceAll("\"+\\{", "{").replaceAll("\\}\"+", "}").replaceAll("\"+\\[", "[").replaceAll("\\]\"+", "]");
        return result;
	}
	
	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public short getPage() {
		return page;
	}


	public void setPage(short page) {
		this.page = page;
	}


	public short getRowsPerPage() {
		return rowsPerPage;
	}


	public void setRowsPerPage(short rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}
}

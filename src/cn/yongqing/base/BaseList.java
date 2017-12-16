package cn.yongqing.base;

import java.util.List;

/**
 * <p>Title: 级联对象</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: </p>
 * @author 董有红
 * @version 1.0
 */

public abstract class BaseList extends Base {
	
	private static final long serialVersionUID = 3380016993124229949L;;

	/** 父对象 */
	private BaseList parent;

	/** 子对象 */
	private List<BaseList> children;
	

    public BaseList() {
    	
    }
    
	public BaseList getParent() {
		return parent;
	}

	public void setParent(BaseList parent) {
		this.parent = parent;
	}

	public List<BaseList> getChildren() {
		return children;
	}

	public void setChildren(List<BaseList> children) {
		this.children = children;
	}
}

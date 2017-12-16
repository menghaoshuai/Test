package cn.yongqing.json.entity;

import cn.yongqing.base.Base;
import cn.yongqing.id.entity.IDRrcord;

public class Json extends Base {
	/**
	 * 
	 */
	private static final long serialVersionUID = 695895655661L;

	private IDRrcord idRrcord;
	
	private String shenFenZheng;
	
	private String name;

	public String getShenFenZheng() {
		return shenFenZheng;
	}

	public void setShenFenZheng(String shenFenZheng) {
		this.shenFenZheng = shenFenZheng;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IDRrcord getIdRrcord() {
		return idRrcord;
	}

	public void setIdRrcord(IDRrcord idRrcord) {
		this.idRrcord = idRrcord;
	}

}

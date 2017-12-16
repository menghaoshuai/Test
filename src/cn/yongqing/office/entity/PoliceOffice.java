package cn.yongqing.office.entity;

import java.util.List;

import cn.yongqing.base.Base;

public class PoliceOffice extends Base {

	private static final long serialVersionUID = 114498997751L;
	
	/**机关名称*/
	private String name;
	
	/**机器人mac*/
	private String mac;
	
	/**区域code*/
	private int aeraCode;
	
	private List<PeoplePolice> polices;
	
	private List<Locations> locations;

	public int getAeraCode() {
		return aeraCode;
	}

	public void setAeraCode(int aeraCode) {
		this.aeraCode = aeraCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public List<PeoplePolice> getPolices() {
		return polices;
	}

	public void setPolices(List<PeoplePolice> polices) {
		this.polices = polices;
	}

	public List<Locations> getLocations() {
		return locations;
	}

	public void setLocations(List<Locations> locations) {
		this.locations = locations;
	}

}

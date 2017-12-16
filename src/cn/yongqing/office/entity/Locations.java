package cn.yongqing.office.entity;

import java.util.List;

import cn.yongqing.base.Base;

public class Locations extends Base {

	private static final long serialVersionUID = 136987456654L;
	
	/**位置名称*/
	private String locationName;
	
	/**经度*/
	private double longitude;
	
	/**纬度*/
	private double latitude;
	
	/**实景照片*/
	private String photo;
	
	/**位置描述*/
	private String description;
	
	/**区域code*/
	private int aeraCode;
	
	private List<Locations> resultList;

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAeraCode() {
		return aeraCode;
	}

	public void setAeraCode(int aeraCode) {
		this.aeraCode = aeraCode;
	}

	public List<Locations> getResultList() {
		return resultList;
	}

	public void setResultList(List<Locations> resultList) {
		this.resultList = resultList;
	}

}

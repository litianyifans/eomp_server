package com.titans.mobile.model;

import java.sql.Timestamp;
import java.util.List;

public class Station {
	/**
	 * 主键ID
	 */
	
	
	private String id;

	/**
	 * 外键关联 系统模块的运营组织类； 与orgId对应， 一个运营组织中可能包含多个充电站 1:n关系
	 */
	
	private Org org ;
	
	private String userId ;
	
	/**
	 * 站编号
	 */
	private String stationNumber;

	/**
	 * 站名称
	 */
	private String stationName;

	/**
	 * 充电站城市地址
	 */
	private String city;

	/**
	 * 充电站城市地址
	 */
	private String cityCode;

	/**
	 * 充电站街道地址
	 */
	private String address;

	/**
	 * 经度
	 */
	private double lng;

	/**
	 * 纬度
	 */
	private double lat;

	/**
	 * 当前默认系统时间， 自动赋值
	 */
	private Timestamp sysTime;

	/**
	 * 备注
	 */
	private String remark;
	
	private String imgUrl ;
	
	private String freeCount ;
	
	private String chargeCount ;
	
	private String faultCount ;
	
	private String offlineCount ;
	
	

	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	/*
	 * 站下的充电桩、级联删除
	 */
	private List stakes;
	
	public Station() {
	}


	public Station(String id, Org org, String userId, String stationNumber, String stationName, String city,
			String cityCode, String address, double lng, double lat, Timestamp sysTime, String remark, String imgUrl,
			List stakes) {
		super();
		this.id = id;
		this.org = org;
		this.userId = userId;
		this.stationNumber = stationNumber;
		this.stationName = stationName;
		this.city = city;
		this.cityCode = cityCode;
		this.address = address;
		this.lng = lng;
		this.lat = lat;
		this.sysTime = sysTime;
		this.remark = remark;
		this.imgUrl = imgUrl;
		this.stakes = stakes;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public Org getOrg() {
		return org;
	}
	public void setOrg(Org org) {
		this.org = org;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStationNumber() {
		return stationNumber;
	}

	public void setStationNumber(String stationNumber) {
		this.stationNumber = stationNumber;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public Timestamp getSysTime() {
		return sysTime;
	}

	public void setSysTime(Timestamp sysTime) {
		this.sysTime = sysTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getFreeCount() {
		return freeCount;
	}
	public void setFreeCount(String freeCount) {
		this.freeCount = freeCount;
	}
	public String getChargeCount() {
		return chargeCount;
	}
	public void setChargeCount(String chargeCount) {
		this.chargeCount = chargeCount;
	}
	public String getFaultCount() {
		return faultCount;
	}
	public void setFaultCount(String faultCount) {
		this.faultCount = faultCount;
	}
	public String getOfflineCount() {
		return offlineCount;
	}
	public void setOfflineCount(String offlineCount) {
		this.offlineCount = offlineCount;
	}
	public List getStakes() {
		return stakes;
	}

	public void setStakes(List stakes) {
		this.stakes = stakes;
	}
	
	

}

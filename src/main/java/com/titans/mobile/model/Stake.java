package com.titans.mobile.model;

import java.sql.Timestamp;

public class Stake {
	private static final long serialVersionUID = 7499516523242285032L;

	/**
	 * 主键ID
	 */
	private String id;

	/**
	 * 外键关联充电站类 与stationId对应， 一个充电站包含多个充电桩 1:n关系
	 */
	private String stationId;

	/**
	 * 外键关联 系统模块的用户类； 与userId对应，当前充电桩入库建立者，一个用户可能建立多个充电桩 1：n关系
	 */
	private String  userId;

	/**
	 * 外键关联 系统模块的运营组织类； 与orgId对应， 一个运营组织中可能包含多个充电桩 1:n关系
	 */
	private String orgId;
	
	/**
	 * 外键关联 Contract类； 与contractId对应，  1:n关系
	 */
	private String contractId;

	/**
	 * 外键关联一次电桩型号与templateId对应，一个充电桩型号包含多个充电桩 1:n关系
	 */
	private String templateId;

	/**
	 * 充电桩编号（运营商编号+生厂厂家编码+产品类别编码+产品编号）
	 */
	private String stakeNumber;

	/**
	 * 充电桩别名
	 */
	private String alias;

	/**
	 * 生厂厂家编码+产品类别编码+出厂产品编号
	 */
	private String ftyCode;

	/**
	 * 产品类别编码
	 */
	private String typeCode;

	/**
	 * 出厂产品编号
	 */
	private String prodCode;

	/**
	 * 充电桩类型，有交流、直流两种类型
	 */
	private String type;

	/**
	 * 额定功率
	 */
	private Double power;

	/**
	 * 充电枪个数 默认为2个 一般为1、2、4
	 */
	private Integer chargeCount;

	/**
	 * 是否投入运营 默认为投入运营 VALUE=1
	 */
	private Boolean isOperation;

	/**
	 * ctiy -> 省、市、区县<br>
	 * 充电桩地址 离散充电桩，此值有效；<br>
	 * 当充电桩隶属于充电站时，以充电站地址为准，值可以空。<br>
	 */
	private String city;

	/**
	 * ctiy -> 省、市、区县对应的编码<br>
	 * 充电桩地址 离散充电桩，此值有效；<br>
	 * 当充电桩隶属于充电站时，以充电站地址为准，值可以空。<br>
	 */
	private String cityCode;

	/**
	 * address -> 街道地址 <br>
	 * 充电桩地址 离散充电桩，此值有效；<br>
	 * 当充电桩隶属于充电站时，以充电站地址为准，值可以空。<br>
	 */
	private String address;

	/**
	 * 经度
	 */
	private Double lng;

	/**
	 * 纬度
	 */
	private Double lat;

	/**
	 * 当前系统时间
	 */
	private Timestamp sysTime;

	/**
	 * 备注 描述
	 */
	private String remark;

	/**
	 * 充电桩参数，一对多双向关联
	 */
	//private Set<StakeParm> stakeParms;

	/**
	 * 充电桩与组件多对多关联
	 */
	//private Set<StakeCompRela> stakeCompRelas;

	
	/**
	 * 充电桩状态
	 */
	private String chargeStatus;

	
    /**
     * 桩号.
     */
    private String stakeCode;
    
    private  String stationCode ;
    
	public Stake() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getStakeNumber() {
		return stakeNumber;
	}

	public void setStakeNumber(String stakeNumber) {
		this.stakeNumber = stakeNumber;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getFtyCode() {
		return ftyCode;
	}

	public void setFtyCode(String ftyCode) {
		this.ftyCode = ftyCode;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPower() {
		return power;
	}

	public void setPower(Double power) {
		this.power = power;
	}

	public Integer getChargeCount() {
		return chargeCount;
	}

	public void setChargeCount(Integer chargeCount) {
		this.chargeCount = chargeCount;
	}

	public Boolean getIsOperation() {
		return isOperation;
	}

	public void setIsOperation(Boolean isOperation) {
		this.isOperation = isOperation;
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

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
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

	public String getChargeStatus() {
		return chargeStatus;
	}

	public void setChargeStatus(String chargeStatus) {
		this.chargeStatus = chargeStatus;
	}

	public String getStakeCode() {
		return stakeCode;
	}

	public void setStakeCode(String stakeCode) {
		this.stakeCode = stakeCode;
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

	
	
	
    

}

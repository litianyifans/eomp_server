package com.titans.mobile.model;

public class Org {
	/**
	 * 序列化serialVersionUID.
	 */
	private static final long serialVersionUID = 6860102374765450842L;

	/**
	 * 内部主键 .
	 */
	private String id;

	/**
	 * 组织代码 .
	 */
	private String orgCode;

	/**
	 * 组织名称 .
	 */
	private String orgName;

	/**
	 * 填写组织相关附属信息，如电话、办公地点 .
	 */
	private String remark;

	/**
	 * 父级编码
	 */
	private String parentID;

	/**
	 * 排序树型编码，例如5位树型编排序 .
	 */
	private String sorting;

	/**
	 * 运营类别 .
	 */
	private String businessType;

	// (运营名称)非持久化
	private String businessName;
	

	/**
	 * 是否运营商 标识当前组织是否为运营商（实体组织），只有运营商属性才做具体的业务数据，默认值为0否，1表示是
	 */
	private int operator;

	
	
	public Org() {
	}


	public Org(String id, String orgCode, String orgName, String remark, String parentID, String sorting,
			String businessType, String businessName, int operator) {
		super();
		this.id = id;
		this.orgCode = orgCode;
		this.orgName = orgName;
		this.remark = remark;
		this.parentID = parentID;
		this.sorting = sorting;
		this.businessType = businessType;
		this.businessName = businessName;
		this.operator = operator;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getOrgCode() {
		return orgCode;
	}


	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}


	public String getOrgName() {
		return orgName;
	}


	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getParentID() {
		return parentID;
	}


	public void setParentID(String parentID) {
		this.parentID = parentID;
	}


	public String getSorting() {
		return sorting;
	}


	public void setSorting(String sorting) {
		this.sorting = sorting;
	}


	public String getBusinessType() {
		return businessType;
	}


	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}


	public String getBusinessName() {
		return businessName;
	}


	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}


	public int getOperator() {
		return operator;
	}


	public void setOperator(int operator) {
		this.operator = operator;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}

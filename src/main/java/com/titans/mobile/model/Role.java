package com.titans.mobile.model;

public class Role {
	/**
	 * 序列化serialVersionUID.
	 */
	private static final long serialVersionUID = 5705717217762161664L;

	/**
	 * 内部主键 .
	 */
	private String id;

	private String orgID;

	/**
	 * 参数英文名称，系统唯一 .
	 */
	private String roleName;

	/**
	 * 用于描述此角色包括的功能 .
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrgID() {
		return orgID;
	}

	public void setOrgID(String orgID) {
		this.orgID = orgID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	
}

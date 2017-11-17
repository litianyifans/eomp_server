package com.titans.mobile.model;



/**
 * User.<br>
 * @author molin <br>
 * @version 1.0.0 <br>
 * @since JDK 1.6.0
 */
public class User  {

	/**
	 * 序列化serialVersionUID.
	 */
	private static final long serialVersionUID = 1830852044231863048L;

	/**
	 * 内部主键 .
	 */
	private String id;

	/**
	 * 用户账号，系统唯一 .
	 */
	private String userAccount;

	/**
	 * 用户名称，系统内可允许重名 .
	 */
	private String userName;

	/**
	 * 电子邮件，发邮件提醒 .
	 */
	private String email;

	/**
	 * 固定电话， .
	 */
	private String telephone;

	/**
	 * 手机号码，仅允许填写一个 可用户发短信 .
	 */
	private String mobile;

	/**
	 * 身份证号 .
	 */
	private String idcard;

	/**
	 * 备注 .
	 */
	private String remark;
	
	/**
	 * 机构
	 */
	private Org org ;
	
	private Role role ;


	
	/**
	 * 所属角色列表.
	 */
	private String roleNames;

	public String getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}

	/**
	 * 密码的安全策略.
	 */
	private UserSecurity userSecurity;

	public UserSecurity getUserSecurity() {
		return userSecurity;
	}

	public void setUserSecurity(UserSecurity userSecurity) {
		this.userSecurity = userSecurity;
	}

	/**
	 * 获取 内部主键 .
	 * @return the id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * 设置 内部主键 .
	 * @param newid
	 */
	public void setId(final String newid) {
		this.id = newid;
	}

	/**
	 * 获取 用户账号，系统唯一 .
	 * @return the useraccount
	 */
	public String getUserAccount() {
		return this.userAccount;
	}

	/**
	 * 设置 用户账号，系统唯一 .
	 * @param newuseraccount
	 */
	public void setUserAccount(final String newuserAccount) {
		this.userAccount = newuserAccount;
	}

	/**
	 * 获取 用户名称，系统内可允许重名 .
	 * @return the username
	 */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * 设置 用户名称，系统内可允许重名 .
	 * @param newusername
	 */
	public void setUserName(final String newUserName) {
		this.userName = newUserName;
	}

	/**
	 * 获取 电子邮件，发邮件提醒 .
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * 设置 电子邮件，发邮件提醒 .
	 * @param newemail
	 */
	public void setEmail(final String newemail) {
		this.email = newemail;
	}

	/**
	 * 获取 固定电话， .
	 * @return the telephone
	 */
	public String getTelephone() {
		return this.telephone;
	}

	/**
	 * 设置 固定电话， .
	 * @param newtelephone
	 */
	public void setTelephone(final String newtelephone) {
		this.telephone = newtelephone;
	}

	/**
	 * 获取 手机号码，仅允许填写一个 可用户发短信 .
	 * @return the mobile
	 */
	public String getMobile() {
		return this.mobile;
	}

	/**
	 * 设置 手机号码，仅允许填写一个 可用户发短信 .
	 * @param newmobile
	 */
	public void setMobile(final String newmobile) {
		this.mobile = newmobile;
	}

	/**
	 * 获取 身份证号 .
	 * @return the idcard
	 */
	public String getIdcard() {
		return this.idcard;
	}

	/**
	 * 设置 身份证号 .
	 * @param newidcard
	 */
	public void setIdcard(final String newidcard) {
		this.idcard = newidcard;
	}

	/**
	 * 获取 备注 .
	 * @return the remark
	 */
	public String getRemark() {
		return this.remark;
	}

	/**
	 * 设置 备注 .
	 * @param newremark
	 */
	public void setRemark(final String newremark) {
		this.remark = newremark;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}
	
}

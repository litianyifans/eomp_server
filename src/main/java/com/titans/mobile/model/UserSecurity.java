package com.titans.mobile.model;
import java.util.Date;

/**
 * Usersecurity.<br>
 * @author molin <br>
 * @version 1.0.0 <br>
 * @since JDK 1.7.0
 */
public class UserSecurity  {

	/**
	 * 序列化serialVersionUID.
	 */
	private static final long serialVersionUID = 7834275313030501767L;

	/**
	 * 内部主键 .
	 */
	private String id;

	/**
	 * 用户密码，初始时读取系统参数设置的默认密码，必须是加密储存 .
	 */
	private String userPwd;
	
	private String passwdSalt;

	/**
	 * 默认当前日期 .
	 */
	private Date validStartDate;

	/**
	 * 账号结束期，默认为2999-12-31号 .
	 */
	private Date validEndDate;

	/**
	 * 0停用，1启用、2异常 （默认值为0） .
	 */
	private Integer accountStatus;

	/**
	 * 记录上次修改密码时间 .
	 */
	private Date lastChangeTime;

	/**
	 * 记录用户上次被锁定的时间 .
	 */
	private Date lastLockTime;

	/**
	 * user .
	 */
	private User user;

	/**
	 * 用户id
	 */
	private String userID;
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
	 * 获取 用户密码，初始时读取系统参数设置的默认密码，必须是加密储存 .
	 * @return the userpwd
	 */
	public String getUserPwd() {
		return this.userPwd;
	}

	/**
	 * 设置 用户密码，初始时读取系统参数设置的默认密码，必须是加密储存 .
	 * @param newuserpwd
	 */
	public void setUserPwd(final String newUserPwd) {
		this.userPwd = newUserPwd;
	}

	/**
	 * 获取 默认当前日期 .
	 * @return the validStartDate
	 */
	public Date getValidStartDate() {
		return this.validStartDate;
	}

	/**
	 * 设置 默认当前日期 .
	 * @param newvalidStartDate
	 */
	public void setValidStartDate(final Date newValidStartDate) {
		this.validStartDate = newValidStartDate;
	}

	/**
	 * 获取 账号结束期，默认为2999-12-31号 .
	 * @return the validEndDate
	 */
	public Date getValidEndDate() {
		return this.validEndDate;
	}

	/**
	 * 设置 账号结束期，默认为2999-12-31号 .
	 * @param newvalidEndDate
	 */
	public void setValidEndDate(final Date newValidEndDate) {
		this.validEndDate = newValidEndDate;
	}

	/**
	 * 获取 0停用，1启用、2异常 （默认值为0） .
	 * @return the accountstatus
	 */
	public Integer getAccountStatus() {
		if (this.accountStatus == null) {
			return 0;
		}
		return this.accountStatus;
	}

	/**
	 * 设置 0停用，1启用、2异常 （默认值为0） .
	 * @param newaccountstatus
	 */
	public void setAccountStatus(final Integer newAccountStatus) {
		this.accountStatus = newAccountStatus;
	}

	/**
	 * 获取 记录上次修改密码时间 .
	 * @return the lastChangeTime
	 */
	public Date getLastChangeTime() {
		return this.lastChangeTime;
	}

	/**
	 * 设置 记录上次修改密码时间 .
	 * @param newlastChangeTime
	 */
	public void setLastChangeTime(final Date newlastChangeTime) {
		this.lastChangeTime = newlastChangeTime;
	}

	/**
	 * 获取 记录用户上次被锁定的时间 .
	 * @return the lastLockTime
	 */
	public Date getLastLockTime() {
		return this.lastLockTime;
	}

	/**
	 * 设置 记录用户上次被锁定的时间 .
	 * @param newlastLockTime
	 */
	public void setLastLockTime(final Date newlastLockTime) {
		this.lastLockTime = newlastLockTime;
	}
	
	public String getPasswdSalt() {
        return passwdSalt;
    }

    public void setPasswdSalt(String passwdSalt) {
        this.passwdSalt = passwdSalt;
    }

    /**
	 * 获取 user .
	 * @return the user
	 */
	public User getUser() {
		return this.user;
	}

	/**
	 * 设置 user .
	 * @param newuser
	 */
	public void setUser(final User newuser) {
		this.user = newuser;
	}

	
	/**
	 * 获取userID.
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	
	/**
	 * 设置userID.
	 * @param set userID 
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
}

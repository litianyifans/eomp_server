package com.titans.mobile.utils;


/**
 * 账号状态.<br>
 * 
 * @author molin <br>
 * @version 1.0.0 2016-10-21<br>
 * @see
 * @since JDK 1.5.0
 */
public enum Accountstatus {
	/**
	 * 停用 .
	 */
	STOP,
	/**
	 * 启用.
	 */
	VALID,
	/**
	 * 异常.
	 */
	ERROR;

	public static final String[] CAPTIONS = new String[] { "停用 ", "启用", "异常" };
}

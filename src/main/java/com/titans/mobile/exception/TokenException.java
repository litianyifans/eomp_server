package com.titans.mobile.exception;

/**
 * Title: 自定义的RuntimeException
 * Description:Token过期时抛出
 * @author liw
 * @created 2017年10月12日 下午4:56:44
 */
public class TokenException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String msg;

	public TokenException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}

package com.titans.mobile.utils;

import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import javassist.expr.NewArray;

/**
 * Title: 统一响应结构 Description:使用REST框架实现前后端分离架构，我们需要首先确定返回的JSON响应结构是统一的，
 * 也就是说，每个REST请求将返回相同结构的JSON响应结构.
 * 
 * @author liw
 * @created 2017年10月12日 下午5:06:00
 */
public class ResponseResult {
	private String code;
	private String message;
	private Object data;

	public ResponseResult() {
		this.setCode(ResultCode.SUCCESS);
		this.setMessage("成功！");

	}

	public ResponseResult(ResultCode code) {
		this.setCode(code);
		this.setMessage(code.msg());
	}

	public ResponseResult(ResultCode code, String message) {
		this.setCode(code);
		this.setMessage(message);
	}
	public ResponseResult(Object data) {
		this.setCode(ResultCode.SUCCESS);
		this.setMessage("成功！");
		this.setData(data);
	}

	public ResponseResult(ResultCode code, String message, Object data) {
		this.setCode(code);
		this.setMessage(message);
		this.setData(data);
	}

	public String getCode() {
		return code;
	}

	public void setCode(ResultCode code) {
		this.code = code.val();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}

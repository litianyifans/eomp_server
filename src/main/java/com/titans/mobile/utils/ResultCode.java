package com.titans.mobile.utils;

public enum ResultCode {
	 /** 成功 */  
    SUCCESS("200", "成功"),  
      
    /** 没有登录 */  
    NOT_LOGIN("400", "没有登录"),  
    
    /** 发生异常 */  
    EXCEPTION("401", "发生异常"),  
      
    /** 系统错误 */  
    SYS_ERROR("402", "系统错误"),  
      
    /** 参数错误 */  
    PARAMS_ERROR("403", "参数错误 "),  
      
    /** 不支持或已经废弃 */  
    NOT_SUPPORTED("410", "不支持或已经废弃"),  
    
    /** 密码错误,请重新输入 */  
    USER_PASSWORD_LOCK("439", "密码错误,请重新输入"),
    /** 该账户已锁定，请联系管理员启用！ */  
    USER_ACCOUNT_LOCK("440", "该账户已锁定，请联系管理员启用！"),
    
    /** 该账户异常，请联系管理员恢复 */  
    USER_ACCOUNT_ERROR("441", "该账户异常，请联系管理员恢复"),
    
    /** 用户不存在,请联系管理员补充完整信息 */  
    USER_SECURITY_ERROR("442", "用户不存在,请联系管理员补充完整信息"),
      
    /** 登陆校验失败 */  
    LOGIN_CHECK_ERROR("443", "登陆校验失败"), 
    
    /** AuthCode错误 */  
    INVALID_AUTHCODE("444", "无效的Token"),  
    
    /** 太频繁的调用 */  
    TOO_FREQUENT("445", "太频繁的调用"), 
    
    /** 添加扫码token失败 */  
    ADD_QRCODE_ERROR("446", "添加扫码token失败"),  
    
    /** 获取RandomCodeMap的用户名失败 */  
    QRCODE_USERNAME_ERROR("447", "获取RandomCodeMap的用户名失败"),  
    
    /** 二维码不存在 */  
    QRCODE_NULL_ERROR("448", "二维码不存在"), 
      
    /** 未知的错误 */  
    UNKNOWN_ERROR("499", "未知错误");  
      
    private ResultCode(String value, String msg){  
        this.val = value;  
        this.msg = msg;  
    }  
      
    public String val() {  
        return val;  
    }  
  
    public String msg() {  
        return msg;  
    }  
      
    private String val;  
    private String msg;  
}

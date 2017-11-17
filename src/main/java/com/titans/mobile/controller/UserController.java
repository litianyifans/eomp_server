package com.titans.mobile.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.titans.mobile.annotation.IgnoreSecurity;
import com.titans.mobile.model.User;
import com.titans.mobile.model.UserSecurity;
import com.titans.mobile.service.UserService;
import com.titans.mobile.utils.Accountstatus;
import com.titans.mobile.utils.Md5;
import com.titans.mobile.utils.ResponseResult;
import com.titans.mobile.utils.ResultCode;



/**
 * Title: 用户管理 
 * Description: 对用户资源的增删改查
 * 
 * @author liw
 * @created 2017年10月12日 下午4:54:32
 */
@RestController
@RequestMapping("/users")
public class UserController {
	private static final Logger log = Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/getUserByuserAccount/{userAccount}", method = RequestMethod.GET, produces = "application/json")
	public ResponseResult getUserByuserAccount(@PathVariable("userAccount") String userAccount) {
		User user = userService.getUserByUserAccount(userAccount) ;
		return new ResponseResult(user) ;
	}
	
	/**     
	 * @description 修改用户密码
	 * @author liw       
	 * @created 2017年10月12日 下午4:53:58     
	 */
	@RequestMapping(value="/modifyUserInfoByUserName" ,method = RequestMethod.POST)
	public ResponseResult modifyUserInfoByUserName(@RequestParam("userName") String userName,
			@RequestParam("oldPassword") String oldPassword,@RequestParam("newPassword") String newPassword){
		UserSecurity userSecurity = userService.getUserSecurityByUserId(userName) ;
		boolean flag = true ;
		if (userSecurity == null) {
            flag = false ;
        }
	    String inputPasswd = (userSecurity.getPasswdSalt() == null ? new Md5(oldPassword)
                : new Md5(oldPassword + userSecurity.getPasswdSalt())).getStringDigest();
	    String inputNewPassword = (userSecurity.getPasswdSalt() == null ? new Md5(newPassword)
                : new Md5(newPassword + userSecurity.getPasswdSalt())).getStringDigest();
	    if (!inputPasswd.equalsIgnoreCase(userSecurity.getUserPwd())) {
	    	flag = false ;
        }
	    if (userSecurity.getAccountStatus() == Accountstatus.STOP.ordinal()) {
            throw new RuntimeException("该账户已锁定，请联系管理员启用！");
        }

        if (userSecurity.getAccountStatus() == Accountstatus.ERROR.ordinal()) {
            throw new RuntimeException("该账户异常，请联系管理员恢复！");
        }
		if(flag){
			flag = userService.updateUserPasswordByuserName(userName, inputNewPassword) ;
		}
		if(flag){
			return new ResponseResult() ;
		}else{
			return new ResponseResult(ResultCode.EXCEPTION);
		}
	}
	

}

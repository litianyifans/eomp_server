package com.titans.mobile.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.titans.mobile.annotation.IgnoreSecurity;
import com.titans.mobile.model.User;
import com.titans.mobile.model.UserSecurity;
import com.titans.mobile.security.DefaultTokenManager;
import com.titans.mobile.service.TokenManager;
import com.titans.mobile.service.UserService;
import com.titans.mobile.utils.Accountstatus;
import com.titans.mobile.utils.Constants;
import com.titans.mobile.utils.CookieUtil;
import com.titans.mobile.utils.Md5;
import com.titans.mobile.utils.ResponseResult;
import com.titans.mobile.utils.ResultCode;
import com.titans.mobile.utils.WebContextUtil;

/**        
 * Title: Token的管理    
 * Description: 处理用户的登录、登出操作
 * @author liw       
 * @created 2017年10月12日 下午4:52:58    
 */      
@RestController
@RequestMapping("/oauth")
public class TokenController {
	
	
	@Autowired
	private TokenManager defaultTokenManager;
	@Autowired
	private UserService userService;
	private static final Logger log = Logger.getLogger(TokenController.class);



	  
	/**     
	 * @description 登录处理
	 * @author liw       
	 * @created 2017年10月12日 下午4:53:58     
	 */
	@RequestMapping(value="/token" ,method = RequestMethod.POST)
	@IgnoreSecurity
	public ResponseResult login(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		boolean flag = true ;
		UserSecurity userSecurity = userService.getUserSecurityByUserId(username) ;
		
		if (userSecurity == null) {
            flag = false ;
        }
	    String inputPasswd = (userSecurity.getPasswdSalt() == null ? new Md5(password)
                : new Md5(password + userSecurity.getPasswdSalt())).getStringDigest();
	    if (!inputPasswd.equalsIgnoreCase(userSecurity.getUserPwd())) {
	    	flag = false ;
        }
	    if (userSecurity.getAccountStatus() == Accountstatus.STOP.ordinal()) {
            throw new RuntimeException("该账户已锁定，请联系管理员启用！");
        }

        if (userSecurity.getAccountStatus() == Accountstatus.ERROR.ordinal()) {
            throw new RuntimeException("该账户异常，请联系管理员恢复！");
        }
        User user = userService.getUserByUserAccount(username) ;
		if (flag) {
			String token = defaultTokenManager.createToken(username);
			log.debug("**** Generate Token **** : " + token);
			Map<String,String> sessionInfo = new HashMap<String,String>() ;
			sessionInfo.put(Constants.DEFAULT_TOKEN_NAME, token) ;
			sessionInfo.put(Constants.USER_ACCOUNT, username) ;
			sessionInfo.put(Constants.USER_ID, user.getId()) ;
			sessionInfo.put(Constants.ORG_ID, user.getOrg().getId()) ;
			return new ResponseResult(sessionInfo);
		}
		return new ResponseResult(ResultCode.LOGIN_CHECK_ERROR);
	}
	
	
	@RequestMapping(value="/checkRandomCode/{randomCode}" ,method = RequestMethod.GET)
	public ResponseResult checkRandomCode(@PathVariable("randomCode") String randomCode) {
	  System.out.println("randomCode:"+randomCode);	
	  boolean flag = defaultTokenManager.checkRandomCode(randomCode);
	  if(flag){
		  return new ResponseResult();
	  }else{
		  return new ResponseResult(ResultCode.QRCODE_NULL_ERROR);
	  }
	 
	}
	@RequestMapping(value="/addScanLoginToken" ,method = RequestMethod.POST)
	public ResponseResult addScanLoginToken(@RequestParam("randomCode") String randomCode) {
	  String token = WebContextUtil.getRequest().getHeader(
	                Constants.DEFAULT_TOKEN_NAME);
	  
	  String userAccount = defaultTokenManager.getUserAccount(token) ;
	  System.out.println("addToken:"+token);
	  System.out.println("userAccount:"+userAccount);
	  System.out.println("randomCode:"+randomCode);
	  boolean flag = defaultTokenManager.addRandomCodeMap(randomCode.trim(),userAccount) ;
	  System.out.println("flag:"+flag);
	  if(flag){
		  return new ResponseResult();
	  }else{
		  return new ResponseResult(ResultCode.ADD_QRCODE_ERROR);
	  }
	 
	}
	
	@RequestMapping(value="/checkScanLoginToken/{randomCode}" ,method = RequestMethod.GET)
	@IgnoreSecurity
	public ResponseResult checkScanLoginToken(@PathVariable("randomCode") String randomCode) {
	   System.out.println("checkScanLoginToken---randomCode:"+randomCode);
	   String userAccount = defaultTokenManager.getUserNameByRandCodeMap(randomCode.trim()) ;
	   System.out.println("checkScanLoginToken---userAccount:"+userAccount);
	   if("".equals(userAccount)||userAccount == null){
		   return new ResponseResult(ResultCode.QRCODE_USERNAME_ERROR);
	   }else{
		   Map result = new HashMap<String,String>() ;
		   result.put("userAccount", userAccount) ;
		   return new ResponseResult(result) ;
	   }
	}
	
	/**     
	 * @description 校验Token是否存在
	 * @author liw       
	 * @created 2017年10月12日 下午4:53:58     
	 */
	@RequestMapping(value="/validatorToken" ,method = RequestMethod.GET)
	public ResponseResult checkContainToken(HttpServletRequest request,HttpServletResponse response) {
	   return new ResponseResult();
	}
	/**     
	 * @description 更新Token
	 * @author liw       
	 * @created 2017年10月12日 下午4:53:58     
	 */
	@RequestMapping(value="/refreshToken" ,method = RequestMethod.GET)
	public ResponseResult refreshToken(HttpServletRequest request,HttpServletResponse response) {
		 // 从 request header 中获取当前 token
        String token = request.getHeader(
                Constants.DEFAULT_TOKEN_NAME);
       defaultTokenManager.refreshToken(token);
       Cookie cookie = new Cookie(Constants.DEFAULT_TOKEN_NAME, token);
	   cookie.setPath("/");
	   response.addCookie(cookie);
	   return new ResponseResult();
	}
	
	
	
	/**     
	 * @description 登出处理
	 * @author liw       
	 * @created 2017年10月12日 下午4:53:58     
	 */
	@RequestMapping(method = RequestMethod.DELETE)
	@IgnoreSecurity
	public ResponseResult logout(HttpServletRequest request) {
		String token = request.getHeader(Constants.DEFAULT_TOKEN_NAME);
		defaultTokenManager.deleteToken(token);
		log.debug("Logout Success...");
		return new ResponseResult();
	}
}

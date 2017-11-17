package com.titans.mobile.service;

import org.springframework.stereotype.Service;

/**        
 * Title: REST 鉴权   
 * Description: 登录用户的身份鉴权
 * @author liw       
 * @created 2017年7月4日 下午4:41:43    
 */ 
@Service
public interface  TokenManager {
	String createToken(String username);  
    boolean checkToken(String token); 
    String refreshToken(String token) ;
    void deleteToken(String token);
}

package com.titans.mobile.security;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.titans.mobile.service.TokenManager;


/**        
 * Title: TokenManager的默认实现    
 * Description: 管理 Token
 * @author liw       
 * @created 2017年10月12日    
 */
@Service
public class DefaultTokenManager implements TokenManager  {
	/** 将token存储到JVM内存(ConcurrentHashMap)中    */      
    private static Map<String, String> tokenMap = new ConcurrentHashMap<String, String>();
    
	/** 将randomCode存储到JVM内存(ConcurrentHashMap)中    */      
    private static Map<String, String> randomCodeMap = new ConcurrentHashMap<String, String>();
    
	@Override
	public String createToken(String userAccount) {
		 String token = UUID.randomUUID().toString().replaceAll("-", "");
	     tokenMap.put(token, userAccount);
	     return token;
	}
	public String getUserAccount(String token){
		return tokenMap.get(token) ;
	}
	public boolean checkRandomCode(String randomCode){
		return randomCodeMap.containsKey(randomCode);
	}
	
	@Override
	public boolean  addRandomCodeMap(String randomCode,String userAccount){
		 randomCodeMap.put(randomCode, userAccount);
	     return true;
	}
	@Override
	public String  getUserNameByRandCodeMap(String randomCode){
		return randomCodeMap.get(randomCode);
	}
	
	
	@Override
	public boolean checkToken(String token) {
        return !StringUtils.isEmpty(token) && tokenMap.containsKey(token);
	}
	@Override
	public String refreshToken(String token) {
		String userName = tokenMap.get(token);
		deleteToken(token);
		return createToken(userName);
	}


	@Override
	public void deleteToken(String token) {
		tokenMap.remove(token);
	}

}

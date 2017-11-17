package com.titans.mobile.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.titans.mobile.mapper.UserMapper;
import com.titans.mobile.mapper.UserSecurityMapper;
import com.titans.mobile.model.Org;
import com.titans.mobile.model.User;
import com.titans.mobile.model.UserSecurity;
import com.titans.mobile.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserSecurityMapper userSecurityMapper;
	

	public User getUserByUserAccount(String userAccount){
		return userMapper.getUserByUserAccount(userAccount);
	}
	
	
	public UserSecurity getUserSecurityByUserId (String userId){
		return  userSecurityMapper.findByUserId(userId);
	}
	
	public boolean updateUserPasswordByuserName (String username ,String password){
	    try{
	    	userSecurityMapper.updateUserPasswordByuserName(username,password);
	    	return true ;
	    }catch(Exception e){
	    	return false ;
	    }
	
	}
	
	
	public List<Org> findOrgsByUserId(Map paramMap){
		return userMapper.findOrgsByUserId(paramMap) ;
	}
	
}

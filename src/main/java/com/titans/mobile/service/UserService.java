package com.titans.mobile.service;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.titans.mobile.model.Org;
import com.titans.mobile.model.User;
import com.titans.mobile.model.UserSecurity;


@Service
public interface UserService {
	User getUserByUserAccount(String userAccount) ;
	
	UserSecurity getUserSecurityByUserId (String userId);
	
    boolean updateUserPasswordByuserName (String username ,String password);
    
	List<Org> findOrgsByUserId(Map paramMap);
}

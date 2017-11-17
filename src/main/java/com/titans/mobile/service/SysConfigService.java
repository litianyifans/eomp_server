package com.titans.mobile.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.titans.mobile.model.SysPublic;



@Service
public interface SysConfigService {
	List<SysPublic> getSysPublics() ;
	SysPublic getSysPublicById(String sysId) ;
}

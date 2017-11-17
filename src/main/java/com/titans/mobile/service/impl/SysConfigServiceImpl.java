package com.titans.mobile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.titans.mobile.mapper.SysPublicMapper;
import com.titans.mobile.model.SysPublic;
import com.titans.mobile.service.SysConfigService;



@Service
public class SysConfigServiceImpl implements SysConfigService{
	@Autowired
	public SysPublicMapper sysPublicMapper ;
	
	
	@Override
	public List<SysPublic> getSysPublics() {
		return sysPublicMapper.getSysPublics();
	}

	@Override
	public SysPublic getSysPublicById(String sysId) {
		return sysPublicMapper.getSysPublicById(Integer.parseInt(sysId));
	}

	
}

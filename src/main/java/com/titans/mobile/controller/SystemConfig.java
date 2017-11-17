package com.titans.mobile.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.titans.mobile.annotation.IgnoreSecurity;
import com.titans.mobile.model.SysPublic;
import com.titans.mobile.service.SysConfigService;
import com.titans.mobile.utils.ResponseResult;

/**
 * Title: 系统配置
 * Description: 对系统公告的配置
 * 
 * @author liw
 * @created 2017年11月14日 下午4:54:32
 */
@RestController
@RequestMapping("/sysConfig")
public class SystemConfig {
	private static final Logger log = Logger.getLogger(SystemConfig.class);
	@Autowired
	private SysConfigService sysConfigService;
	
	@RequestMapping(value = "/getSysPublics", method = RequestMethod.GET, produces = "application/json")
	//@IgnoreSecurity
	public ResponseResult getSysPublics() {
		List<SysPublic> sysPublics = sysConfigService.getSysPublics() ;
		return new ResponseResult(sysPublics) ;
	}
	
	@RequestMapping(value = "/getSysPublicById/{sysId}", method = RequestMethod.GET, produces = "application/json")
	//@IgnoreSecurity
	public ResponseResult getSysPublicById(@PathVariable("sysId") String sysId) {
		SysPublic sysPublic = sysConfigService.getSysPublicById(sysId) ;
		return new ResponseResult(sysPublic) ;
	}
	

}

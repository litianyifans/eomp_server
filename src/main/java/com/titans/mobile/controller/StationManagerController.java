package com.titans.mobile.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.titans.mobile.annotation.IgnoreSecurity;
import com.titans.mobile.model.Stake;
import com.titans.mobile.model.Station;
import com.titans.mobile.service.StationService;
import com.titans.mobile.utils.ResponseResult;



/**
 * Title: 充电站管理
 * Description: 对充电站的管理
 * @author liw
 * @created 2017年10月12日 下午4:54:32
 */
@RestController
@RequestMapping("/stations")
public class StationManagerController {
	private static final Logger log = Logger.getLogger(StationManagerController.class);
	@Autowired
	StationService stationService ;
	
	@RequestMapping(value = "/getStationsByUserAccount/{userAccount}", method = RequestMethod.GET, produces = "application/json")
	//@IgnoreSecurity
	public ResponseResult getStationsByUserAccount(@PathVariable("userAccount") String userAccount) {
		List<Station> stations = stationService.getStationsInfoByUserAccount(userAccount);
		return new ResponseResult(stations) ;
	}
	@RequestMapping(value = "/getStakesByStationId/{stationId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseResult getStakesByStationId(@PathVariable("stationId") String stationId) {
		List<Stake> stakes = stationService.getStakesByStationId(stationId) ;
		return  new ResponseResult(stakes);
	}
	@RequestMapping(value = "/getStakeInfoByStakeNumber/{stakeNumber}", method = RequestMethod.GET, produces = "application/json")
	//@IgnoreSecurity
	public ResponseResult getStakeInfoByStakeNumber(@PathVariable("stakeNumber") String stakeNumber) {
		Map<String,Object> stakeInfo = stationService.getStakeInfoByStakeNumber(stakeNumber) ;
		return  new ResponseResult(stakeInfo);
	}
	
	@RequestMapping(value = "/getStakeAlarmByStakeNumber/{stakeNumber}", method = RequestMethod.GET, produces = "application/json")
	//@IgnoreSecurity
	public ResponseResult getStakeAlarmByStakeNumber(@PathVariable("stakeNumber") String stakeNumber) {
		List<Map<String,Object>> statkeAlarms = stationService.getStakeAlarmByStakeNumber(stakeNumber) ;
		return  new ResponseResult(statkeAlarms);
	}
	@RequestMapping(value = "/getStakeChargeStatusByStakeNumber/{stakeNumber}", method = RequestMethod.GET, produces = "application/json")
	//@IgnoreSecurity
	public ResponseResult getStakeChargeStatusByStakeNumber(@PathVariable("stakeNumber") String stakeNumber) {
		List<Map<String,Object>> statkeAlarm = stationService.getStakeChargeStatusByStakeNumber(stakeNumber) ;
		return  new ResponseResult(statkeAlarm);
	}
	
	
	@RequestMapping(value = "/getAlarmInfosByUserIdAndOrgId/{userId}/{orgId}", method = RequestMethod.GET, produces = "application/json")
	//@IgnoreSecurity
	public ResponseResult getAlarmInfosByUserIdAndOrgId(@PathVariable("userId") String userId,@PathVariable("orgId") String orgId) {
		 Map<String,String> paramMap = new HashMap<String,String>() ;
		 paramMap.put("userId", userId);
		 paramMap.put("orgId", orgId);
		List<Map<String,Object>> alarmInfos = stationService.findAlarmInfosByUserIdAndOrgId(paramMap);
		return  new ResponseResult(alarmInfos);
	}
	
	@RequestMapping(value = "/getFaultInfosByUserIdAndOrgId/{userId}/{orgId}", method = RequestMethod.GET, produces = "application/json")
	//@IgnoreSecurity
	public ResponseResult getFaultInfosByUserIdAndOrgId(@PathVariable("userId") String userId,@PathVariable("orgId") String orgId) {
		 Map<String,String> paramMap = new HashMap<String,String>() ;
		 paramMap.put("userId", userId);
		 paramMap.put("orgId", orgId);
		List<Map<String,Object>> alarmInfos = stationService.findFaultInfosByUserIdAndOrgId(paramMap);
		return  new ResponseResult(alarmInfos);
	}  
	
	@RequestMapping(value = "/getStakeCompareMap", method = RequestMethod.GET, produces = "application/json")
	//@IgnoreSecurity
	public ResponseResult getStakeCompareMap() {
		List<Map<String,Object>> stakes = stationService.getStakeUnStorageList();
		return  new ResponseResult(stakes);
	}  
	
	

	
}

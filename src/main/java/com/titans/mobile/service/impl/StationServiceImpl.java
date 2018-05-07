package com.titans.mobile.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.titans.mobile.mapper.StationMapper;
import com.titans.mobile.model.Stake;
import com.titans.mobile.model.Station;
import com.titans.mobile.service.StationService;


@Service
public class StationServiceImpl implements StationService{
	@Autowired
	StationMapper stationMapper ;
	
	public List<Station> getStationsInfoByUserAccount(String userId){
		return (List<Station>) stationMapper.getStationsInfoByUserAccount(userId) ;
	}
	
	public List<Stake> getStakesByStationId(String stationId){
		return stationMapper.getStakesByStationId(stationId) ;
	}
	
	public Map<String,Object> getStakeInfoByStakeNumber(String stakeNumber){
		return stationMapper.getStakeInfoByStakeNumber(stakeNumber) ;
	}
	public List<Map<String,Object>> getStakeAlarmByStakeNumber(String stakeNumber){
		return stationMapper.getStakeAlarmByStakeNumber(stakeNumber) ;
	}
	
	public List<Map<String,Object>> getStakeChargeStatusByStakeNumber(String stakeNumber){
		return stationMapper.getStakeChargeStatusByStakeNumber(stakeNumber) ;
	}
	
	public List<Map<String,Object>> findAlarmInfosByUserIdAndOrgId(Map paramMap){
		return stationMapper.findAlarmInfosByUserIdAndOrgId(paramMap) ;
	}
	
	public List<Map<String,Object>> findFaultInfosByUserIdAndOrgId(Map paramMap){
		return stationMapper.findFaultInfosByUserIdAndOrgId(paramMap) ;
	}
	
	public List<Map<String,Object>> getStakeUnStorageList(){
		return stationMapper.getStakeUnStorageList();
	}

}

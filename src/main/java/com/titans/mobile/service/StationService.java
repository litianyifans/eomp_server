package com.titans.mobile.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.titans.mobile.model.Stake;
import com.titans.mobile.model.Station;

@Service
public interface StationService {
	List<Station> getStationsInfoByUserAccount(String userAccount) ;
	
	List<Stake> getStakesByStationId(String stationId) ;
	Map<String,Object> getStakeInfoByStakeNumber(String stakeId) ;
	List<Map<String,Object>> getStakeAlarmByStakeNumber(String stakeNumber) ;
	List<Map<String,Object>> getStakeChargeStatusByStakeNumber(String stakeNumber) ;
	public List<Map<String,Object>> findAlarmInfosByUserIdAndOrgId(Map paramMap) ;
	public List<Map<String,Object>> findFaultInfosByUserIdAndOrgId(Map paramMap) ;
	public List<Map<String,Object>> getStakeUnStorageList() ;
	public List<Map<String,Object>> findStakeChargeReport(Map paramMap) ;
}

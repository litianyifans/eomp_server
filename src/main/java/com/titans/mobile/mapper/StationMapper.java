package com.titans.mobile.mapper;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.titans.mobile.model.Stake;
import com.titans.mobile.model.Station;


@Mapper
public interface StationMapper {
	
	List<Station> getStationsInfoByUserAccount(@Param("userAccount") String userAccount);
	
	List<Stake> getStakesByStationId(@Param("stationId") String stationId) ;
	
	Map<String,Object> getStakeInfoByStakeNumber(@Param("stakeNumber") String stakeNumber) ;
	
	List<Map<String,Object>> getStakeAlarmByStakeNumber(@Param("stakeNumber") String stakeNumber) ;
	
	List<Map<String,Object>> getStakeChargeStatusByStakeNumber(@Param("stakeNumber") String stakeNumber) ;
	
	List<Map<String,Object>> findAlarmInfosByUserIdAndOrgId(Map paramMap) ;
	
	List<Map<String,Object>> findFaultInfosByUserIdAndOrgId(Map paramMap) ;
}

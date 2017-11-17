package com.titans.mobile.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.titans.mobile.model.SysPublic;


@Mapper
public interface SysPublicMapper {
		
	@Select("select * from eomp_sys_public")
	List<SysPublic> getSysPublics();
	
	@Select("select * from eomp_sys_public a where a.id =#{sysId}  ")
	SysPublic getSysPublicById(@Param("sysId") Integer sysId) ; 
}

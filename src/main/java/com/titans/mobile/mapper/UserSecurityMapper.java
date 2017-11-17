package com.titans.mobile.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.titans.mobile.model.UserSecurity;

@Mapper
public interface UserSecurityMapper {
	
	@Select("select b.* from eomp_sys_user a left join eomp_sys_usersecurity b on a.id = b.userId where a.userAccount = #{userId}")
	UserSecurity findByUserId(@Param("userId") String userId);	
	
	@Update("update eomp_sys_usersecurity a set a.userPwd = #{password} where a.userId  = (select id from eomp_sys_user b where b.userAccount = #{userName} ) ")
	int updateUserPasswordByuserName(@Param("userName") String userName,@Param("password") String password);

}

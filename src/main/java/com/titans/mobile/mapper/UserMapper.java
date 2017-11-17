package com.titans.mobile.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.titans.mobile.model.Org;
import com.titans.mobile.model.User;

@Mapper
public interface UserMapper {
		
	User getUserByUserAccount(@Param("userAccount") String userAccount);
	@Select("select * from user where name = #{name}")
	User findByName(@Param("name") String name);
	@Insert("insert into user(id,name,age) values(#{id}, #{name},#{age})")
	int insert(@Param("id") Integer id, @Param("name") String name, @Param("age") Integer age);
	
	User findUserInfo();
	
	List<Org> findOrgsByUserId(Map paramMap);
}

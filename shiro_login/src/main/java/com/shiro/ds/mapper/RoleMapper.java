package com.shiro.ds.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
@Mapper
public interface RoleMapper {
    @Select("select role_id from account_user_role where username = #{username}")
    LinkedList<Integer> findUserByName(@Param("username") String name);
}

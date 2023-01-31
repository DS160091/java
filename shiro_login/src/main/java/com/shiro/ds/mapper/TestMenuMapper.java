package com.shiro.ds.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMenuMapper {
    @Select("select distinct menu_id from account_role_menu where role_id = #{role_id}")
    List<Integer> testgetmenu(@Param("role_id") int role_id);
}

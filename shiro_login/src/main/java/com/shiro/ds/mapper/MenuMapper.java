package com.shiro.ds.mapper;

import com.shiro.ds.pojo.MenuPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
import java.util.List;

@Mapper
public interface MenuMapper {
    //    @Select("select distinct menu_id from account_role_menu  where role_id in #{role_id}")
//    @Select({
//            "<script>",
//            "select",
//            "distinct menu_id",
//            "from account_role_menu",
//            "where role_id in",
//            "<foreach collection='role_id' item='id' open='(' separator=',' close=')'>",
//            "#{id}",
//            "</foreach>",
//            "</script>"
//    })
    @Select("select distinct menu_id from account_role_menu  where role_id = #{role_id}")
    List<Integer> findMenuIdsByRoleIds(@Param("role_id") List<Integer> role_id);

    @Select({
            "<script>",
            "select *",
            "from account_menu",
            "where id in",
            "<foreach collection='id' item='tmp' open='(' separator=',' close=')'>",
            "#{tmp}",
            "</foreach>",
            "order by pid,seq",
            "</script>"
    })
    List<MenuPO> findTitleMenuByIds(@Param("id") List<Integer> id);
}

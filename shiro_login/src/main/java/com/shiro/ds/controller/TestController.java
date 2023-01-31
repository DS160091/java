package com.shiro.ds.controller;

import com.shiro.ds.mapper.TestMenuMapper;
import com.shiro.ds.pojo.MenuPO;
import com.shiro.ds.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@Controller
public class TestController {
    @Autowired
    private MenuService menuService;

    private TestMenuMapper testMenuMapper;
    @ResponseBody
    @RequestMapping(value = "/test/getrolelist")
    public List<Integer> getRoleList(String username){
        return menuService.getRoleList(username);
    }


    @ResponseBody
    @RequestMapping(value = "/test/getmenulist")
    public List<Integer> getMenuList(@RequestParam("role_id") List<Integer>  role_id){
        return menuService.getmenuList(role_id);
//        return testMenuMapper.testgetmenu(role_id);
    }

    @ResponseBody
    @RequestMapping("/test/getmenu1")
    public List<Integer> getMenulist1(String username){
        return menuService.getmenuList(menuService.getRoleList(username));
    }


}

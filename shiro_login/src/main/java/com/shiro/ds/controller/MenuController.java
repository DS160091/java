package com.shiro.ds.controller;


import com.shiro.ds.pojo.MenuPO;
import com.shiro.ds.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;
//String user
    @RequestMapping("/test/getmenu")
    public String getMenu(@RequestParam("username") String username){
        List<MenuPO> list = menuService.getMenuList(username);
        return list.toString();
    }
}

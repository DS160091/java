package com.shiro.ds.service;

import com.shiro.ds.pojo.MenuPO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MenuService {
    List<MenuPO> getMenuList(String user);

    List<Integer> getRoleList(String user);

    List<Integer> getmenuList(List<Integer> rolelist);

}

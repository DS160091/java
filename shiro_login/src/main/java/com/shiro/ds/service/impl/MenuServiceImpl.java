package com.shiro.ds.service.impl;

import com.shiro.ds.mapper.MenuMapper;
import com.shiro.ds.mapper.RoleMapper;
import com.shiro.ds.pojo.MenuPO;
import com.shiro.ds.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<MenuPO> getMenuList(String user) {
//        定义返回结构resultlist
        LinkedList<MenuPO> resultlist = new LinkedList<>();
        try{
//1.根据user获取roleid   account_user_role
            List<Integer> role = getRoleList(user);
//2.根据roleid获取menuid   account_role_menu
            List<Integer> menu = getmenuList(role);
//3.根据menuid获取menu_title  account_menu
            List<MenuPO> titles = menuMapper.findTitleMenuByIds(menu);

            for (MenuPO title: titles) {
                if(title.getType() == 2){
                    List<MenuPO> subMenuList = getSubMenuList(titles, title.getId());
                    title.setSubMenuList(subMenuList);
                    resultlist.add(title);
                }
            }
//3.根据menuid获取menu
            }catch (Exception e){
                e.printStackTrace();
            }

        return resultlist;
    }

    @Override
    public List<Integer> getRoleList(String user) {
        return roleMapper.findUserByName(user);
    }

    @Override
    public List<Integer> getmenuList(List<Integer> rolelist) {
            return menuMapper.findMenuIdsByRoleIds(rolelist);
    }

    public List<MenuPO> getSubMenuList(List<MenuPO> menus, int pid) {
        List<MenuPO> subMenuList = new ArrayList<>();
        for (MenuPO menu : menus) {
            if (menu.getPid() == pid && menu.getType() >= 1) {
                subMenuList.add(menu);
            }

        }

        return subMenuList;
    }
}

package com.shiro.ds.pojo;


import com.shiro.ds.utils.ExtJSBaseParameter;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MenuPO extends ExtJSBaseParameter {

    public static final int TYPE_PARENT = 2;
    public static final int TYPE_CHILD = 1;
    List<MenuPO> subMenuList = new ArrayList<MenuPO>();
    private int id = -1;
    private String url = ""; //href
    private String menuclass = "";    // 按钮图片
    private String name = ""; // 显示名称
    private int pid = 0;  // 默认0， 一级菜单
    private int type = 0; //1. 一级菜单， 2。 二级菜单
    private int seq = 0;
    private int vue = 0;
    private boolean active = false;  //needAjax = true, 标识该菜单局部刷新，调用

    public int getVue() {
        return vue;
    }

    public void setVue(int vue) {
        this.vue = vue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMenuclass() {
        return menuclass;
    }

    public void setMenuclass(String menuclass) {
        this.menuclass = menuclass;
    }


    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<MenuPO> getSubMenuList() {
        return subMenuList;
    }

    public void setSubMenuList(List<MenuPO> subMenuList) {
        this.subMenuList = subMenuList;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Menu [id=");
        builder.append(id);
        builder.append(", url=");
        builder.append(url);
        builder.append(", name=");
        builder.append(name);
        builder.append(", pid=");
        builder.append(pid);
        builder.append(", type=");
        builder.append(type);
        builder.append(", active=");
        builder.append(active);
        builder.append(", subMenuList=");
        builder.append(subMenuList);
        builder.append("]\n");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((url == null) ? 0 : url.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        MenuPO other = (MenuPO) obj;
        if (url == null) {
            return other.url == null;
        } else {
            return url.equals(other.url);
        }
    }

}

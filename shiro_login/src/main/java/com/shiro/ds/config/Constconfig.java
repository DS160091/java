package com.shiro.ds.config;

public class Constconfig {

    public static final boolean DEBUG = false;
    public static String PUBLIC_SALT = "Did23&wU@gf5Fd";

    public static final String SESSION_USER = "sessionUser";
    public static final String SESSION_USER_INFO = "sessionUserInfo";
    public static final String SESSION_IP = "sessionIP";
    public static final String SESSION_DEPARTMENT = "sessionDepartment";
    public static final String SESSION_PLATFORM = "sessionPlatform";
    public static final String SESSION_ROLE_RIGHTS = "sessionRoleRights";

    public static final String HOLLA = "holla";
    public static final String SIX_HOUSE = "six";
    public static final String HUAJIAO = "huajiao";
    public static final String INNOVATE = "innovate";

    public static final String NO_INTERCEPTOR_PATH = ".*/((login)|(vuelogin/newLogin)|(vuelogin)|(vue/login)|(vue/page/)|(vuelogin)|(actuator)|(vuetest)|(vuetestdev)|(app/page/download/pageImage)|(logout)|(test)|(inter)|(resultset)|(weixin)|(static)|(main)|(error)|(websocket)|(vue/h5auto)).*"; // 不对匹配该值的访问路径拦截（正则）
    public static final String SESSION_currMenu = "currMenu"; // 当前访问页面
    public static final String LOGIN = "http://localhost:8080/#/vue/page/newlogin"; // 登录地址

    public static final String SESSION_menuList = "menuList"; // 当前菜单
    public static final String SESSION_allmenuList = "allmenuList"; // 全部菜单
    public static final String SESSION_urlmenuMap = "urlmenuMap"; // url 到 menu的映射
}

package com.shiro.ds.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.shiro.ds.shiro.MyRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class shrio_config {
//    @Autowired
//    private MyRealm myRealm;
//   3. factorybean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("manager")DefaultWebSecurityManager manager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(manager);
//        设置shiro内置过滤器
/**
 * anon:无需认证就可以访问
 * authc:必须认证才能访问
 * user:必须拥有记住我功能才能访问
 * role:拥有某个角色权限才可以访问
 * perms:拥有某个资源的权限才能访问
 */

        Map<String, String> filterMap = new LinkedHashMap<>();
//        只有授权才能访问
        filterMap.put("/user/add","perms[user:add]");
        filterMap.put("/user/update","perms[user:update]");
//        filterMap.put("/user/add","authc");
//        filterMap.put("/user/update","authc");
        filterMap.put("/user/*","authc");
        factoryBean.setFilterChainDefinitionMap(filterMap);
        factoryBean.setLoginUrl("/tologin");

//        设置未授权跳转页面
        factoryBean.setUnauthorizedUrl("/unauth");


        return factoryBean;
    }
//   2. securitymanager

    @Bean("manager")
    public DefaultWebSecurityManager Manager(@Qualifier("realm") MyRealm realm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
//        关联realm
        manager.setRealm(realm);
        return manager;
    }
////   1. realm,自定义realm类
    @Bean("realm")
    public MyRealm myRealm(){
        return new MyRealm();
    }

    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

}

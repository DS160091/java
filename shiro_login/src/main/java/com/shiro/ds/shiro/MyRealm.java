package com.shiro.ds.shiro;

import com.shiro.ds.pojo.AccountUser;
import com.shiro.ds.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
//    授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.addStringPermission("user:add");
        Subject subject = SecurityUtils.getSubject();
        AccountUser user = (AccountUser)subject.getPrincipal();
        System.out.println(String.format("%s==%s==%s",user.getName(),user.getPwd(),user.getRole()));
        if(user.getRole().equals("admin")){
            info.addStringPermission("user:add");
        }

        return info;
    }
//    验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了认证");

        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String username = token.getUsername();
            AccountUser user = userService.getUserInfoByName(username);

        System.out.println("======"+user.getName());
        System.out.println("======"+user.getPwd());
        if(user == null){
            return null;//抛出UnknownAccountException
        }
        Subject currentsubject = SecurityUtils.getSubject();
        Session session = currentsubject.getSession();
        session.setAttribute("loginuser",user);
// shiro防止密码泄露，shiro进行密码验证,不需要自己手动验证
        return new SimpleAuthenticationInfo(user,user.getPwd(), user.getName());
    }
}

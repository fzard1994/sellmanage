package com.example.demo.config;

import com.example.demo.pojo.Staff;
import com.example.demo.service.StaffImp;
import org.apache.catalina.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    StaffImp staffImp;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.printf("执行授权");
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        Subject subject= SecurityUtils.getSubject();
        Staff staff= (Staff) subject.getPrincipal();
        info.addStringPermission(staff.getLevel());
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证");
        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
        String username=token.getUsername();
        Staff staff=staffImp.selectStaffById(username);
        if (staff==null){
            return null;
        }

        return new SimpleAuthenticationInfo(staff,staff.getPassword(),"");
    }
}

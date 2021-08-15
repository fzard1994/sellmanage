package com.example.demo.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public MyRealm myRealm(){
        return new MyRealm();
    }

    @Bean
    public DefaultWebSecurityManager securityManager(@Qualifier("myRealm")MyRealm myRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean getBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        /*设置权限*/
        Map map=new LinkedHashMap();
        map.put("/CustomerManage/*","authc");
        map.put("/ManagerController/*","authc");
        map.put("/RecycleBinController/*","authc");
        map.put("/RemarksController/*","authc");
        map.put("/templates/html/mainPage.html","authc");
        map.put("/mainPage","authc");
        map.put("/RecycleBin","authc");
        map.put("/ManagerPage","authc");
        bean.setFilterChainDefinitionMap(map);
        bean.setLoginUrl("/login");
        return bean;
    }
}

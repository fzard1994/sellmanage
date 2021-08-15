package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class mvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /*一：首页设置*/
        registry.addViewController("/").setViewName("login");
        /*登录判断*/
        registry.addViewController("/templates/html/mainPage.html").setViewName("mainPage");

        /*跳转*/
        registry.addViewController("/mainPage").setViewName("customerManage");
        registry.addViewController("/RecycleBin").setViewName("RecycleBin");
        registry.addViewController("/ManagerPage").setViewName("ManagerPage");
    }
}

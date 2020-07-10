package com.yuezisen.demo01.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 名字 邮箱
 * @date 2020-7-9
 * Copyright© 2008-2020 苏州同元软控信息技术有限公司 All Rights Reserved.
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //重写WebMvcConfigurer中的addViewControllers方法，将首页设置为login.html
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
    }
}

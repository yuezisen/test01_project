package com.yuezisen.demo01.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.RegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yuezisen 2863590460@qq.com
 * @date 2020-7-7
 * Copyright© 2008-2020 苏州同元软控信息技术有限公司 All Rights Reserved.
 */

/**
 * @Configuration:表明此类可以代替配置文件 完成一定部分的参数配置
 * @ConfigurationProperties(prefix = "spring.datasource")：导入已有配置文件中的配置参数
 */
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }
    //druid -- 配置一个监控数据动向的监控器servlet
    @Bean
    public ServletRegistrationBean staViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> initParamMaps = new HashMap<>();
        initParamMaps.put("loginUsername","admin");
        initParamMaps.put("loginPassword","123456");
        initParamMaps.put("allow","");
        initParamMaps.put("deny","");
        bean.setInitParameters(initParamMaps);
        return bean ;
    }
    //druid -- 配置一个web的filter
    public FilterRegistrationBean webstatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        bean.setUrlPatterns(Arrays.asList("/*"));

        Map<String,String> initParamMaps = new HashMap<>();
        initParamMaps.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParamMaps);
        return bean;
    }
}

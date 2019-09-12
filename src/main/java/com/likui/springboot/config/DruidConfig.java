package com.likui.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DruidConfig
 * @Description: 数据源 配置类
 * @Author: LiKui
 * @Date: 2019-9-11 18:40
 * @Version: 1.0
 */
@Configuration
public class DruidConfig {
    //配置数据源属性
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    @Bean
   public DataSource myDruid(){
        return new DruidDataSource();
    }

    //配置druid 的监控
    //1.配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        //监控后台  属性
        Map<String,String> initParams = new HashMap<>();
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword", "123456");
        //默认允许所有访问
        initParams.put("allow","");
        //不允许访问的ip
        //initParams.put("deny","192.168.0.118");
        bean.setInitParameters(initParams);
        return bean;
    }

    //2.配置一个web监控的 Filter 监听
    @Bean
    public FilterRegistrationBean webFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        HashMap<String, String> map = new HashMap<>();
        map.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(map);
        bean.setUrlPatterns(Arrays.asList("/"));
        return bean;
    }



}
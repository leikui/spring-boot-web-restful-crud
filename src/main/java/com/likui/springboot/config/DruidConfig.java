package com.likui.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @ClassName: DruidConfig
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-9-11 18:40
 * @Version: 1.0
 */
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource durid(){
        return new DruidDataSource();
    }

}
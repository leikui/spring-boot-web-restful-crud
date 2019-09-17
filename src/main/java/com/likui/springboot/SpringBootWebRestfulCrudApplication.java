package com.likui.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.likui.springboot.mapper")
@SpringBootApplication
/**
 * 1.开启基于缓存的注解 @EnableCaching
 * 2、标注基于缓存注解
 *
 */
@EnableCaching
public class SpringBootWebRestfulCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebRestfulCrudApplication.class, args);
    }

}

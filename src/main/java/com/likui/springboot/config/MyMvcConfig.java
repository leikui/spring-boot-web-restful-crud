package com.likui.springboot.config;

import com.likui.springboot.component.LoginHandlerInterceptor;
import com.likui.springboot.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: MyConfig
 * @Description: SpringMVC部分配置类
 * @Author: LiKui
 * @Date: 2019-9-4 18:12
 * @Version: 1.0
 */
//全面接管SpringMVC配置
//@EnableWebMvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * webmvcconfig 组件 接管 SpringMVC的部分配置
     * @return
     */
    @Bean //将组件注册在容器中
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer mvcConfigurer = new WebMvcConfigurer(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            /**
             * 注册拦截器
             * @param registry
             */
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //拦截的路径  与 不拦截白名单
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/","/index.html","/user/login","/webjars/**","/asserts/**");
            }
        };
        return mvcConfigurer;
    }

    /**
     * //国际化接口配置
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocalResolver();
    }


}
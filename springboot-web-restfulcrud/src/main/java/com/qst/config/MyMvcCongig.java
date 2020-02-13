package com.qst.config;

import com.qst.compoment.LoginHandlerInterceptor;
import com.qst.compoment.MylocaleResolver;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MyMvcCongig implements WebMvcConfigurer {

//    public ConfigurableServletWebServerFactory myconfigurableServletWebServerFactory(){
//        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
//        factory.setPort(8083);
//        return factory;
//    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //工作原理类似于重定向
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("main.html").setViewName("dashboard");
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MylocaleResolver();
    }



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //静态支援映射已经处理完了
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login","/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg","/*.ico");
    }


}

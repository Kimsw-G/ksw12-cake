package com.example.cake.config;

import com.example.cake.inter.LoginChecker;
import com.example.cake.inter.StoreCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    LoginChecker loginChecker;
    @Autowired
    StoreCheck storeCheck;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginChecker).addPathPatterns("/**");
        registry.addInterceptor(storeCheck).addPathPatterns("/user/mystore");
    }
}

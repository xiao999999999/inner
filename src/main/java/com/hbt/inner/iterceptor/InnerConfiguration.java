package com.hbt.inner.iterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class InnerConfiguration extends WebMvcConfigurerAdapter {
    @Autowired
    private LoginRequireInterceptor loginRequireInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginRequireInterceptor);
        super.addInterceptors(registry);
    }
}

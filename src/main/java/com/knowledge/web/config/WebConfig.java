package com.knowledge.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration 
public class WebConfig extends WebMvcConfigurerAdapter {
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/public/**").addResourceLocations("classpath:/public/");
//        super.addResourceHandlers(registry);
        }
}

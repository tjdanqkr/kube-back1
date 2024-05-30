package com.example.demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// cors 설정을 위한 클래스
@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Value("${app.origin}")
    private String origin;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        if(origin.equals("host")) return;
        registry.addMapping("/**")
                .allowedOrigins(origin)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}

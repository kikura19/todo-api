package com.kikura.todo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 全てのエンドポイントを対象に
                .allowedOrigins("http://localhost:4200") // Angularのポートを許可
                .allowedMethods("GET", "POST", "PUT", "DELETE"); // 許可するHTTPメソッド
    }
}
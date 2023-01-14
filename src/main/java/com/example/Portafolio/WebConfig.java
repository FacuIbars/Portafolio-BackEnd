
package com.example.Portafolio;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("auth/login").allowedOrigins("http://localhost:4200/","https://portafolio-adf0a.web.app/")
                .allowedMethods("*").exposedHeaders("*");

    }
}

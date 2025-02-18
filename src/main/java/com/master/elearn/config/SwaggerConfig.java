package com.master.elearn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger configuration for API documentation.
 */
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;


/**
 * Swagger Configuration using springdoc-openapi.
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("E-Learning Platform API")
                        .version("1.0")
                        .description("API documentation for the E-Learning Platform"));
    }
}

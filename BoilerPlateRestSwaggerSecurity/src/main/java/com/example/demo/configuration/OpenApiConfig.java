package com.example.demo.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("BoilerPlate Application API")
                        .description("This is a sample Spring Boot RESTful service using springdoc-openapi and OpenAPI 3, that also uses Spring Security.")
                        .termsOfService("terms")
                        .version("1.0")
                );
    }
}

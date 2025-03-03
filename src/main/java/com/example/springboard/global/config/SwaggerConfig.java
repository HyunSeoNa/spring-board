package com.example.springboard.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

/**
 * fileName     : SwaggerConfig.java
 * author       : hyunseo
 * date         : 2025. 3. 3.
 * description  : Swagger Config
 */
@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot Board Document",
                version = "1.0",
                description = "Spring Boot 게시판 Rest API 문서"
        ),
        servers = {
                @Server(url = "http://localhost:8080", description = "LOCAL Server"),
                @Server(url = "https://api.example.com", description = "Production Server")
        }
)
public class SwaggerConfig {
}

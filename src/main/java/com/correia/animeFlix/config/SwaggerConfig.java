package com.correia.animeFlix.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")  // Nome do grupo de API
                .pathsToMatch("/api/**")  // Caminho das APIs a serem documentadas
                .build();
    }
}

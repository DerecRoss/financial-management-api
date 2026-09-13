package com.gestao_financeira.web.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Financial Management - API",
                version = "1.0",
                description = "API for people management, monthly-payment and payments."
        )
)
public class OpenApiConfig {}
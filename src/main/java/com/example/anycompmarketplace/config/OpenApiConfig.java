package com.example.anycompmarketplace.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Anycomp Marketplace API")
                        .version("1.0.0")
                        .description("REST API for Anycomp Marketplace - Backend Developer Project\n\n" +
                                "This API provides comprehensive marketplace functionality including:\n" +
                                "- Buyer management (CRUD operations)\n" +
                                "- Seller management (CRUD operations)\n" +
                                "- Item management (CRUD operations)\n" +
                                "- Purchase transactions with inventory management"));
    }
}

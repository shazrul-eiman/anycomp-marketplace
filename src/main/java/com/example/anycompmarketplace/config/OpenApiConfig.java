package com.example.anycompmarketplace.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

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
                                "- Purchase transactions with inventory management\n\n" +
                                "**Features:**\n" +
                                "- Input validation\n" +
                                "- Automatic inventory deduction\n" +
                                "- Comprehensive error handling\n" +
                                "- RESTful design principles")
                        .contact(new Contact()
                                .name("ST COMP Holdings")
                                .email("contact@stcompholdings.com")
                                .url("https://stcompholdings.com"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("Development Server"),
                        new Server()
                                .url("https://api.anycomp-marketplace.com")
                                .description("Production Server (Example)")))
                .tags(List.of(
                        new Tag()
                                .name("Buyers")
                                .description("Operations related to buyer management"),
                        new Tag()
                                .name("Sellers")
                                .description("Operations related to seller management"),
                        new Tag()
                                .name("Items")
                                .description("Operations related to item management"),
                        new Tag()
                                .name("Purchases")
                                .description("Operations related to purchase transactions")));
    }
}

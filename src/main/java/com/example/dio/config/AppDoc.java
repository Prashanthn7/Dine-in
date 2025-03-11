package com.example.dio.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class AppDoc {

    @Bean
    OpenAPI OpenApi(){
     return new OpenAPI().info(info());
    }

    private Info info() {
        return new Info()
                .title("Dine In Order API")
                .description("""
                        ## Description 
                        **Dine In Order** is an API using Spring Boot under REST Archietecture
                        The API is designed to serve as a backend to application that deals in Ordering food Online From The table.
                        
                        ## Tech-Stack
                        - Java 8
                        - Spring Boot
                        - Spring Data JPA
                        - MySql DataBase
                        - Spring Security
                        """)
                .version("v1")
                .contact(contact());
    }

    private Contact contact() {
        return new Contact()
                .email("pn342604@gmail.com")
                .url("https://prashanthn7.github.io/Portfolio/")
                .name("Prashanth");
    }
}

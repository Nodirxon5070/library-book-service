package com.company.bookservice.constants;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi groupedByBookAPI(){
        String[] array = new String[]{"/books/create","/books/get/{id}","/books/update/{id}","/books/delete/{id}"};
        return GroupedOpenApi.builder()
                .group("Book")
                .pathsToMatch(array)
                .build();
    }
    @Bean
    public GroupedOpenApi groupedByAuthorAPI(){
        String[] array = new String[]{"/author/create","/author/get/{id}","/author/update/{id}","/author/delete/{id}"};
        return GroupedOpenApi.builder()
                .group("Author")
                .pathsToMatch(array)
                .build();
    }

}

package com.company.bookservice.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorRequestDto {
    private String firstName;
    private String lastName;
    private Integer age;
    private Set<BooksRequestDto> books;

}

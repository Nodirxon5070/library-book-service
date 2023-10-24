package com.company.bookservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BooksDto {
    private Integer bookId;
    @NotBlank(message = "Name cannot be null or empty!")
    private String name;
    private Integer authorId;
    private Integer languageId;
    private Integer imageId;
    private Integer orderBookId;

    private Integer publisherId;
    @NotNull(message = "Price cannot be null or empty!")
    private Float price;
    @NotNull(message = "Page cannot be null or empty!")
    private Integer page;
    @NotNull(message = "Amount cannot be null or empty!")
    private Float amount;

    private LocalDateTime published;

}

package com.company.bookservice.dto.request;

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
public class BooksRequestDto {
    @NotBlank(message = "Name cannot be null or empty!")
    private String name;
    @NotNull(message = "Language id cannot be null or empty")
    private Integer languageId;
    @NotNull(message = "Author id cannot be null or empty")
    private Integer authorId;
    private Integer imageId;
    private Integer orderBookId;

    @NotNull(message = "Publisher id cannot be null or empty")
    private Integer publisherId;
    @NotNull(message = "Price cannot be null or empty!")
    private Float price;
    @NotNull(message = "Page cannot be null or empty!")
    private Integer page;
    @NotNull(message = "Amount cannot be null or empty!")
    private Float amount;

    private LocalDateTime published;

}

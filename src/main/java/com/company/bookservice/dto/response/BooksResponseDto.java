package com.company.bookservice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BooksResponseDto {
    private Integer bookId;
    private String name;
    private Integer authorId;
    private Integer languageId;
    private Integer imageId;
    private Integer orderBookId;

    private Integer publisherId;
    private Float price;
    private Integer page;
    private Float amount;

    private LocalDateTime published;

}

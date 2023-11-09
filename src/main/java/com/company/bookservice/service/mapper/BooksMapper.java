package com.company.bookservice.service.mapper;

import com.company.bookservice.dto.BooksDto;
import com.company.bookservice.dto.request.BooksRequestDto;
import com.company.bookservice.dto.response.BooksResponseDto;
import com.company.bookservice.modul.Books;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public abstract class BooksMapper {

    public abstract Books toEntity(BooksRequestDto dto);

    @Mapping(target = "authorId",ignore = true)
    public abstract BooksResponseDto toDtoNotAuthor(Books books);

    @Mapping(target = "bookId", ignore = true)
    public abstract BooksResponseDto toDto(Books books);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,resultType = Books.class)
    public abstract Books updateBooksFromDto(BooksRequestDto dto, @MappingTarget Books Books);

}

package com.company.bookservice.service.mapper;

import com.company.bookservice.dto.BooksDto;
import com.company.bookservice.modul.Books;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public abstract class BooksMapper {
    @Mapping(target = "bookId", ignore = true)
    public abstract Books toEntity(BooksDto dto);

    @Mapping(target = "authorId",ignore = true)
    public abstract BooksDto toDtoNotAuthor(Books books);

    @Mapping(target = "bookId", ignore = true)
    public abstract BooksDto toDto(Books books);

    @Mapping(target = "bookId", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,resultType = Books.class)
    public abstract Books updateBooksFromDto(BooksDto dto, @MappingTarget Books Books);

}

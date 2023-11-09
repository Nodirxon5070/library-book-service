package com.company.bookservice.service.mapper;

import com.company.bookservice.dto.AuthorDto;
import com.company.bookservice.dto.request.AuthorRequestDto;
import com.company.bookservice.dto.response.AuthorResponseDto;
import com.company.bookservice.modul.Author;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;


@Mapper(componentModel = "spring",imports = Collectors.class)
public abstract class AuthorMapper {

    @Autowired
    public BooksMapper booksMapper;



    @Mapping(target = "books",ignore = true)
    public abstract AuthorResponseDto toDto(Author author);
    public abstract Author toEntity(AuthorRequestDto authorDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,resultType = Author.class)
    public abstract Author updateAuthorFromDto(AuthorRequestDto dto,@MappingTarget Author author);

    @Mapping(target = "books",expression = "java(author.getBooks().stream().map(this.booksMapper::toDtoNotAuthor).collect(Collectors.toSet()))")
    public abstract AuthorResponseDto toDtoWithBooks(Author author);




}

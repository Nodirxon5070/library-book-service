package com.company.bookservice.service.mapper;

import com.company.bookservice.dto.AuthorDto;
import com.company.bookservice.modul.Author;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;


@Mapper(componentModel = "spring",imports = Collectors.class)
public abstract class AuthorMapper {

    @Autowired
    public BooksMapper booksMapper;



    @Mapping(target = "books",ignore = true)
    public abstract AuthorDto toDto(Author author);
    @Mapping(target ="createdAt",ignore = true )
    @Mapping(target ="updatedAt",ignore = true )
    @Mapping(target ="deletedAt",ignore = true )
    public abstract Author toEntity(AuthorDto authorDto);

    @Mapping(target ="createdAt",ignore = true )
    @Mapping(target ="updatedAt",ignore = true )
    @Mapping(target ="deletedAt",ignore = true )
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateAuthorFromDto(AuthorDto dto,@MappingTarget Author author);

    @Mapping(target = "books",expression = "java(author.getBooks().stream().map(this.booksMapper::toDtoNotAuthor).collect(Collectors.toSet()))")
    public abstract AuthorDto toDtoWithBooks(Author author);




}

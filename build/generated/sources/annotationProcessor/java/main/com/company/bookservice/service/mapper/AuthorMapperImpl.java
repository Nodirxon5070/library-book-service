package com.company.bookservice.service.mapper;

import com.company.bookservice.dto.request.AuthorRequestDto;
import com.company.bookservice.dto.request.BooksRequestDto;
import com.company.bookservice.dto.response.AuthorResponseDto;
import com.company.bookservice.dto.response.AuthorResponseDto.AuthorResponseDtoBuilder;
import com.company.bookservice.modul.Author;
import com.company.bookservice.modul.Books;
import com.company.bookservice.modul.Books.BooksBuilder;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-09T16:59:42+0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class AuthorMapperImpl extends AuthorMapper {

    @Override
    public AuthorResponseDto toDto(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorResponseDtoBuilder authorResponseDto = AuthorResponseDto.builder();

        authorResponseDto.authorId( author.getAuthorId() );
        authorResponseDto.firstName( author.getFirstName() );
        authorResponseDto.lastName( author.getLastName() );
        authorResponseDto.age( author.getAge() );
        authorResponseDto.createdAt( author.getCreatedAt() );
        authorResponseDto.updatedAt( author.getUpdatedAt() );
        authorResponseDto.deletedAt( author.getDeletedAt() );

        return authorResponseDto.build();
    }

    @Override
    public Author toEntity(AuthorRequestDto authorDto) {
        if ( authorDto == null ) {
            return null;
        }

        Author author = new Author();

        author.setFirstName( authorDto.getFirstName() );
        author.setLastName( authorDto.getLastName() );
        author.setAge( authorDto.getAge() );
        author.setBooks( booksRequestDtoSetToBooksSet( authorDto.getBooks() ) );

        return author;
    }

    @Override
    public Author updateAuthorFromDto(AuthorRequestDto dto, Author author) {
        if ( dto == null ) {
            return null;
        }

        if ( dto.getFirstName() != null ) {
            author.setFirstName( dto.getFirstName() );
        }
        if ( dto.getLastName() != null ) {
            author.setLastName( dto.getLastName() );
        }
        if ( dto.getAge() != null ) {
            author.setAge( dto.getAge() );
        }
        if ( author.getBooks() != null ) {
            Set<Books> set = booksRequestDtoSetToBooksSet( dto.getBooks() );
            if ( set != null ) {
                author.getBooks().clear();
                author.getBooks().addAll( set );
            }
        }
        else {
            Set<Books> set = booksRequestDtoSetToBooksSet( dto.getBooks() );
            if ( set != null ) {
                author.setBooks( set );
            }
        }

        return author;
    }

    @Override
    public AuthorResponseDto toDtoWithBooks(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorResponseDtoBuilder authorResponseDto = AuthorResponseDto.builder();

        authorResponseDto.authorId( author.getAuthorId() );
        authorResponseDto.firstName( author.getFirstName() );
        authorResponseDto.lastName( author.getLastName() );
        authorResponseDto.age( author.getAge() );
        authorResponseDto.createdAt( author.getCreatedAt() );
        authorResponseDto.updatedAt( author.getUpdatedAt() );
        authorResponseDto.deletedAt( author.getDeletedAt() );

        authorResponseDto.books( author.getBooks().stream().map(this.booksMapper::toDtoNotAuthor).collect(Collectors.toSet()) );

        return authorResponseDto.build();
    }

    protected Books booksRequestDtoToBooks(BooksRequestDto booksRequestDto) {
        if ( booksRequestDto == null ) {
            return null;
        }

        BooksBuilder books = Books.builder();

        books.name( booksRequestDto.getName() );
        books.authorId( booksRequestDto.getAuthorId() );
        books.languageId( booksRequestDto.getLanguageId() );
        books.imageId( booksRequestDto.getImageId() );
        books.publisherId( booksRequestDto.getPublisherId() );
        books.orderBookId( booksRequestDto.getOrderBookId() );
        books.price( booksRequestDto.getPrice() );
        books.page( booksRequestDto.getPage() );
        books.amount( booksRequestDto.getAmount() );
        books.published( booksRequestDto.getPublished() );

        return books.build();
    }

    protected Set<Books> booksRequestDtoSetToBooksSet(Set<BooksRequestDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Books> set1 = new HashSet<Books>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( BooksRequestDto booksRequestDto : set ) {
            set1.add( booksRequestDtoToBooks( booksRequestDto ) );
        }

        return set1;
    }
}

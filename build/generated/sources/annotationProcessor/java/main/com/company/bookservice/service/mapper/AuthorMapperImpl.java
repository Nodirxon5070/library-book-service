package com.company.bookservice.service.mapper;

import com.company.bookservice.dto.AuthorDto;
import com.company.bookservice.dto.AuthorDto.AuthorDtoBuilder;
import com.company.bookservice.dto.BooksDto;
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
    date = "2023-10-19T14:37:39+0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class AuthorMapperImpl extends AuthorMapper {

    @Override
    public AuthorDto toDto(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDtoBuilder authorDto = AuthorDto.builder();

        authorDto.authorId( author.getAuthorId() );
        authorDto.firstName( author.getFirstName() );
        authorDto.lastName( author.getLastName() );
        authorDto.age( author.getAge() );
        authorDto.createdAt( author.getCreatedAt() );
        authorDto.updatedAt( author.getUpdatedAt() );
        authorDto.deletedAt( author.getDeletedAt() );

        return authorDto.build();
    }

    @Override
    public Author toEntity(AuthorDto authorDto) {
        if ( authorDto == null ) {
            return null;
        }

        Author author = new Author();

        author.setAuthorId( authorDto.getAuthorId() );
        author.setFirstName( authorDto.getFirstName() );
        author.setLastName( authorDto.getLastName() );
        author.setAge( authorDto.getAge() );
        author.setBooks( booksDtoSetToBooksSet( authorDto.getBooks() ) );

        return author;
    }

    @Override
    public void updateAuthorFromDto(AuthorDto dto, Author author) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getAuthorId() != null ) {
            author.setAuthorId( dto.getAuthorId() );
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
            Set<Books> set = booksDtoSetToBooksSet( dto.getBooks() );
            if ( set != null ) {
                author.getBooks().clear();
                author.getBooks().addAll( set );
            }
        }
        else {
            Set<Books> set = booksDtoSetToBooksSet( dto.getBooks() );
            if ( set != null ) {
                author.setBooks( set );
            }
        }
    }

    @Override
    public AuthorDto toDtoWithBooks(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDtoBuilder authorDto = AuthorDto.builder();

        authorDto.authorId( author.getAuthorId() );
        authorDto.firstName( author.getFirstName() );
        authorDto.lastName( author.getLastName() );
        authorDto.age( author.getAge() );
        authorDto.createdAt( author.getCreatedAt() );
        authorDto.updatedAt( author.getUpdatedAt() );
        authorDto.deletedAt( author.getDeletedAt() );

        authorDto.books( author.getBooks().stream().map(this.booksMapper::toDtoNotAuthor).collect(Collectors.toSet()) );

        return authorDto.build();
    }

    protected Books booksDtoToBooks(BooksDto booksDto) {
        if ( booksDto == null ) {
            return null;
        }

        BooksBuilder books = Books.builder();

        books.bookId( booksDto.getBookId() );
        books.name( booksDto.getName() );
        books.authorId( booksDto.getAuthorId() );
        books.languageId( booksDto.getLanguageId() );
        books.imageId( booksDto.getImageId() );
        books.publisherId( booksDto.getPublisherId() );
        books.orderBookId( booksDto.getOrderBookId() );
        books.price( booksDto.getPrice() );
        books.page( booksDto.getPage() );
        books.amount( booksDto.getAmount() );
        books.published( booksDto.getPublished() );

        return books.build();
    }

    protected Set<Books> booksDtoSetToBooksSet(Set<BooksDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Books> set1 = new HashSet<Books>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( BooksDto booksDto : set ) {
            set1.add( booksDtoToBooks( booksDto ) );
        }

        return set1;
    }
}

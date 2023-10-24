package com.company.bookservice.service.mapper;

import com.company.bookservice.dto.BooksDto;
import com.company.bookservice.dto.BooksDto.BooksDtoBuilder;
import com.company.bookservice.modul.Books;
import com.company.bookservice.modul.Books.BooksBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-19T14:37:39+0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class BooksMapperImpl extends BooksMapper {

    @Override
    public Books toEntity(BooksDto dto) {
        if ( dto == null ) {
            return null;
        }

        BooksBuilder books = Books.builder();

        books.name( dto.getName() );
        books.authorId( dto.getAuthorId() );
        books.languageId( dto.getLanguageId() );
        books.imageId( dto.getImageId() );
        books.publisherId( dto.getPublisherId() );
        books.orderBookId( dto.getOrderBookId() );
        books.price( dto.getPrice() );
        books.page( dto.getPage() );
        books.amount( dto.getAmount() );
        books.published( dto.getPublished() );

        return books.build();
    }

    @Override
    public BooksDto toDtoNotAuthor(Books books) {
        if ( books == null ) {
            return null;
        }

        BooksDtoBuilder booksDto = BooksDto.builder();

        booksDto.bookId( books.getBookId() );
        booksDto.name( books.getName() );
        booksDto.languageId( books.getLanguageId() );
        booksDto.imageId( books.getImageId() );
        booksDto.orderBookId( books.getOrderBookId() );
        booksDto.publisherId( books.getPublisherId() );
        booksDto.price( books.getPrice() );
        booksDto.page( books.getPage() );
        booksDto.amount( books.getAmount() );
        booksDto.published( books.getPublished() );

        return booksDto.build();
    }

    @Override
    public BooksDto toDto(Books books) {
        if ( books == null ) {
            return null;
        }

        BooksDtoBuilder booksDto = BooksDto.builder();

        booksDto.name( books.getName() );
        booksDto.authorId( books.getAuthorId() );
        booksDto.languageId( books.getLanguageId() );
        booksDto.imageId( books.getImageId() );
        booksDto.orderBookId( books.getOrderBookId() );
        booksDto.publisherId( books.getPublisherId() );
        booksDto.price( books.getPrice() );
        booksDto.page( books.getPage() );
        booksDto.amount( books.getAmount() );
        booksDto.published( books.getPublished() );

        return booksDto.build();
    }

    @Override
    public Books updateBooksFromDto(BooksDto dto, Books Books) {
        if ( dto == null ) {
            return null;
        }

        if ( dto.getName() != null ) {
            Books.setName( dto.getName() );
        }
        if ( dto.getAuthorId() != null ) {
            Books.setAuthorId( dto.getAuthorId() );
        }
        if ( dto.getLanguageId() != null ) {
            Books.setLanguageId( dto.getLanguageId() );
        }
        if ( dto.getImageId() != null ) {
            Books.setImageId( dto.getImageId() );
        }
        if ( dto.getPublisherId() != null ) {
            Books.setPublisherId( dto.getPublisherId() );
        }
        if ( dto.getOrderBookId() != null ) {
            Books.setOrderBookId( dto.getOrderBookId() );
        }
        if ( dto.getPrice() != null ) {
            Books.setPrice( dto.getPrice() );
        }
        if ( dto.getPage() != null ) {
            Books.setPage( dto.getPage() );
        }
        if ( dto.getAmount() != null ) {
            Books.setAmount( dto.getAmount() );
        }
        if ( dto.getPublished() != null ) {
            Books.setPublished( dto.getPublished() );
        }

        return Books;
    }
}

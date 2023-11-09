package com.company.bookservice.service.mapper;

import com.company.bookservice.dto.request.BooksRequestDto;
import com.company.bookservice.dto.response.BooksResponseDto;
import com.company.bookservice.dto.response.BooksResponseDto.BooksResponseDtoBuilder;
import com.company.bookservice.modul.Books;
import com.company.bookservice.modul.Books.BooksBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-09T16:59:41+0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class BooksMapperImpl extends BooksMapper {

    @Override
    public Books toEntity(BooksRequestDto dto) {
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
    public BooksResponseDto toDtoNotAuthor(Books books) {
        if ( books == null ) {
            return null;
        }

        BooksResponseDtoBuilder booksResponseDto = BooksResponseDto.builder();

        booksResponseDto.bookId( books.getBookId() );
        booksResponseDto.name( books.getName() );
        booksResponseDto.languageId( books.getLanguageId() );
        booksResponseDto.imageId( books.getImageId() );
        booksResponseDto.orderBookId( books.getOrderBookId() );
        booksResponseDto.publisherId( books.getPublisherId() );
        booksResponseDto.price( books.getPrice() );
        booksResponseDto.page( books.getPage() );
        booksResponseDto.amount( books.getAmount() );
        booksResponseDto.published( books.getPublished() );

        return booksResponseDto.build();
    }

    @Override
    public BooksResponseDto toDto(Books books) {
        if ( books == null ) {
            return null;
        }

        BooksResponseDtoBuilder booksResponseDto = BooksResponseDto.builder();

        booksResponseDto.name( books.getName() );
        booksResponseDto.authorId( books.getAuthorId() );
        booksResponseDto.languageId( books.getLanguageId() );
        booksResponseDto.imageId( books.getImageId() );
        booksResponseDto.orderBookId( books.getOrderBookId() );
        booksResponseDto.publisherId( books.getPublisherId() );
        booksResponseDto.price( books.getPrice() );
        booksResponseDto.page( books.getPage() );
        booksResponseDto.amount( books.getAmount() );
        booksResponseDto.published( books.getPublished() );

        return booksResponseDto.build();
    }

    @Override
    public Books updateBooksFromDto(BooksRequestDto dto, Books Books) {
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

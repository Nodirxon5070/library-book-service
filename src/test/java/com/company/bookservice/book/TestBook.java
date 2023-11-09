package com.company.bookservice.book;

import com.company.bookservice.dto.ResponseDto;
import com.company.bookservice.dto.request.BooksRequestDto;
import com.company.bookservice.dto.response.BooksResponseDto;
import com.company.bookservice.modul.Books;
import com.company.bookservice.repository.BooksRepository;
import com.company.bookservice.service.BooksService;
import com.company.bookservice.service.mapper.BooksMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TestBook {

    private BooksService booksService;
    private BooksMapper booksMapper;
    private BooksRepository booksRepository;

    @BeforeEach
    void initObject() {
        this.booksMapper = mock(BooksMapper.class);
        this.booksRepository = mock(BooksRepository.class);
        this.booksService = new BooksService(booksRepository, booksMapper);

    }

    /*@Test
    void testSumPositive() {
        int result = booksService.summaToNumber(5, 7);
        Assertions.assertEquals(result, 12);
    }*/

    @Test
    void testCreatePositive() {
        when(booksMapper.toEntity(any()))
                .thenReturn(Books.builder()
                        .bookId(1)
                        .name("Book1")
                        .price(100f)
                        .page(10)
                        .amount(100f)
                        .build());

        when(booksMapper.toDto(any()))
                .thenReturn(BooksResponseDto.builder()
                        .name("Book1")
                        .price(100f)
                        .page(10)
                        .amount(100f)
                        .build());

        ResponseDto<BooksResponseDto> response = this.booksService.create(any());

        assertEquals(response.getCode(), 0, "Error response code");
        assertEquals(response.getData().getName(), "Book1");
        assertTrue(response.isSuccess());
        assertNotNull(response.getData());
        assertNull(response.getErrors());

        verify(this.booksMapper, times(1)).toDto(any());
        verify(this.booksRepository, times(1)).save(any());

    }

    @Test
    void testCreateException() {
        when(booksMapper.toEntity(any()))
                .thenThrow(RuntimeException.class);

        ResponseDto<BooksResponseDto> response = this.booksService.create(any());

        assertEquals(response.getCode(), -2);
        assertFalse(response.isSuccess());
        assertNull(response.getData());

    }

    @Test
    void testGetPositive() {
        when(booksMapper.toDto(any()))
                .thenReturn(BooksResponseDto.builder()
                        .bookId(2)
                        .name("Book1")
                        .price(100f)
                        .page(10)
                        .amount(100f)
                        .build());
        when(this.booksRepository.findByBookId(any()))
                .thenReturn(Optional.ofNullable(Books.builder()
                        .bookId(1)
                        .name("Book1")
                        .price(100f)
                        .page(10)
                        .amount(100f)
                        .build()));

        ResponseDto<BooksResponseDto> response = this.booksService.get(any());

        assertEquals(response.getCode(), 0);
        assertTrue(response.isSuccess());
        assertNotNull(response.getData());
        assertEquals(response.getData().getBookId(), 2);

        verify(this.booksRepository, times(1)).findByBookId(any());
        verify(this.booksMapper, times(1)).toDto(any());


    }

    @Test
    void testGetNegative() {
        when(this.booksRepository.findByBookId(any()))
                .thenReturn(Optional.empty());

        ResponseDto<BooksResponseDto> response = this.booksService.get(any());
        assertEquals(response.getCode(), -1);
        assertNull(response.getData());
        assertFalse(response.isSuccess());


        verify(this.booksRepository, times(1)).findByBookId(any());
    }

    @Test
    void testUpdatePositive() {
        when(booksRepository.findByBookId(any()))
                .thenReturn(Optional.ofNullable(Books.builder()
                        .bookId(1)
                        .name("Book1")
                        .price(100f)
                        .page(10)
                        .amount(100f)
                        .build()));

        when(booksMapper.updateBooksFromDto(any(), any()))
                .thenReturn(Books.builder()
                        .bookId(2)
                        .name("Book1")
                        .price(100f)
                        .page(10)
                        .amount(100f)
                        .build());
        when(booksMapper.toDto(any()))
                .thenReturn(BooksResponseDto.builder()
                        .bookId(3)
                        .name("Book1")
                        .price(100f)
                        .page(10)
                        .amount(100f)
                        .build());
        ResponseDto<BooksResponseDto> response = this.booksService.update(any(), BooksRequestDto.builder()
                .name("Book1")
                .price(100f)
                .page(10)
                .amount(100f)
                .build());
        assertTrue(response.isSuccess());
        assertEquals(response.getCode(), 0);
        assertEquals(response.getData().getBookId(), 3);

        verify(this.booksMapper, times(1)).toDto(any());
        verify(this.booksMapper, times(1)).updateBooksFromDto(any(), any());
        verify(this.booksRepository, times(1)).save(any());
        verify(this.booksRepository, times(1)).findByBookId(any());

    }

    @Test
    void testUpdateNegative() {
        when(this.booksRepository.findByBookId(any()))
                .thenReturn(Optional.empty());

        ResponseDto<BooksResponseDto> response = this.booksService.update(1, any());

        assertFalse(response.isSuccess());
        assertEquals(response.getCode(), -1);
        assertNull(response.getData());
        assertEquals(response.getMessage(), "Book is not found!");

        verify(this.booksRepository, times(1)).findByBookId(any());
    }

    @Test
    void testUpdateException() {
        when(this.booksRepository.findByBookId(any()))
                .thenThrow(RuntimeException.class);

        ResponseDto<BooksResponseDto> response = this.booksService.update(1, any());

        assertEquals(response.getCode(), -2);
        assertFalse(response.isSuccess());
        assertNull(response.getData());
        assertNull(response.getErrors());

        verify(this.booksRepository, times(1)).findByBookId(any());
    }

    @Test
    void testDeletePositive() {
        when(this.booksRepository.findByBookId(any()))
                .thenReturn(Optional.of(
                        Books.builder()
                                .bookId(1)
                                .name("Book1")
                                .price(100f)
                                .page(10)
                                .amount(100f)
                                .build()
                ));
        when(this.booksMapper.toDto(any()))
                .thenReturn(BooksResponseDto.builder()
                        .bookId(2)
                        .name("Book1")
                        .price(100f)
                        .page(10)
                        .amount(100f)
                        .build());
        ResponseDto<BooksResponseDto> response = this.booksService.delete(any());

        assertTrue(response.isSuccess());
        assertEquals(response.getMessage(), "OK");
        assertNotNull(response.getData());
        assertEquals(response.getCode(), 0);

        verify(this.booksRepository, times(1)).findByBookId(any());
        verify(this.booksRepository, times(1)).delete(any());
        verify(this.booksMapper, times(1)).toDto(any());

    }

    @Test
    void testDeleteNegative() {
        when(this.booksRepository.findByBookId(any()))
                .thenReturn(Optional.empty());

        ResponseDto<BooksResponseDto> response = this.booksService.delete(any());

        assertFalse(response.isSuccess());
        assertEquals(response.getMessage(), "Book is not found!");
        assertNull(response.getData());
        assertEquals(response.getCode(), -1);

        verify(this.booksRepository, times(1)).findByBookId(any());
    }

    @Test
    void testDeleteException() {
        when(this.booksRepository.findByBookId(any()))
                .thenThrow(RuntimeException.class);

        ResponseDto<BooksResponseDto> response = this.booksService.delete(any());

        assertFalse(response.isSuccess());
        assertNull(response.getData());
        assertEquals(response.getCode(), -2);

        verify(this.booksRepository, times(1)).findByBookId(any());

    }


}

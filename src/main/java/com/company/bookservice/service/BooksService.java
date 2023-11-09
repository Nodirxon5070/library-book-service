package com.company.bookservice.service;

import com.company.bookservice.dto.*;
import com.company.bookservice.dto.request.BooksRequestDto;
import com.company.bookservice.dto.response.BooksResponseDto;
import com.company.bookservice.modul.Books;
import com.company.bookservice.repository.BooksRepository;
import com.company.bookservice.service.mapper.BooksMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;



@Service
@RequiredArgsConstructor
public class BooksService {

    private final BooksRepository booksRepository;
    protected final BooksMapper booksMapper;

    public ResponseDto<BooksResponseDto> create(@Valid BooksRequestDto dto){
        try {
            Books books = this.booksMapper.toEntity(dto);
            books.setPublished(LocalDateTime.now());
            this.booksRepository.save(books);
            return ResponseDto.<BooksResponseDto>builder()
                    .success(true)
                    .message("OK")
                    .data(this.booksMapper.toDto(books))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<BooksResponseDto>builder()
                    .message(String.format("Book while saving error %s", e.getMessage()))
                    .code(-2)
                    .build();
        }
    }

    public ResponseDto<BooksResponseDto> get(@Valid Integer entityId) {
        return this.booksRepository.findByBookId(entityId)
                .map(books -> ResponseDto.<BooksResponseDto>builder()
                        .success(true)
                        .message("OK")
                        .data(this.booksMapper.toDto(books))
                        .build())
                .orElse(ResponseDto.<BooksResponseDto>builder()
                        .message("Book is not found!")
                        .code(-1)
                        .build());
    }


    public ResponseDto<BooksResponseDto> update(@Valid Integer entityId, BooksRequestDto dto) {
        try {
            return this.booksRepository.findByBookId(entityId)
                    .map(books -> {
                        this.booksMapper.updateBooksFromDto(dto, books);
                        this.booksRepository.save(books);
                        return ResponseDto.<BooksResponseDto>builder()
                                .success(true)
                                .message("OK")
                                .data(this.booksMapper.toDto(books))
                                .build();
                    })
                    .orElse(ResponseDto.<BooksResponseDto>builder()
                            .code(-1)
                            .message("Book is not found!")
                            .build());

        } catch (Exception e) {
            return ResponseDto.<BooksResponseDto>builder()
                    .code(-2)
                    .message(String.format("Book while saving error %s", e.getMessage()))
                    .build();
        }

    }

    public ResponseDto<BooksResponseDto> delete(@Valid Integer entityId) {
      try {
          return this.booksRepository.findByBookId(entityId)
                  .map(books -> {
                      this.booksRepository.delete(books);
                      return ResponseDto.<BooksResponseDto>builder()
                              .success(true)
                              .message("OK")
                              .data(this.booksMapper.toDto(books))
                              .build();
                  })
                  .orElse(ResponseDto.<BooksResponseDto>builder()
                          .message("Book is not found!")
                          .code(-1)
                          .build());
      }
      catch (Exception e){
          return ResponseDto.<BooksResponseDto>builder()
                  .code(-2)
                  .message("Book while deleting error")
                  .build();
      }
    }

    public ResponseDto<List<BooksResponseDto>> getAllBooks(){
        List<Books> list = this.booksRepository.findAll();
        if (list.isEmpty()) {
            return ResponseDto.<List<BooksResponseDto>>builder()
                    .code(-1)
                    .message("Books are not found !")
                    .build();
        }
        return ResponseDto.<List<BooksResponseDto>>builder()
                .success(true)
                .message("OK")
                .data(list.stream().map(this.booksMapper::toDto).toList())
                .build();
    }



}



package com.company.bookservice.service;

import com.company.bookservice.dto.*;
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
public class BooksService implements SimpleCRUD<Integer, BooksDto> {

    private final BooksRepository booksRepository;
    protected final BooksMapper booksMapper;

    public ResponseDto<BooksDto> create(@Valid BooksDto dto){
        try {
            Books books = this.booksMapper.toEntity(dto);
            books.setPublished(LocalDateTime.now());
            this.booksRepository.save(books);
            return ResponseDto.<BooksDto>builder()
                    .success(true)
                    .message("OK")
                    .data(this.booksMapper.toDto(books))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<BooksDto>builder()
                    .message(String.format("Book while saving error %s", e.getMessage()))
                    .code(-2)
                    .build();
        }
    }

    @Override
    public ResponseDto<BooksDto> get(@Valid Integer entityId) {
        return this.booksRepository.findByBookId(entityId)
                .map(books -> ResponseDto.<BooksDto>builder()
                        .success(true)
                        .message("OK")
                        .data(this.booksMapper.toDto(books))
                        .build())
                .orElse(ResponseDto.<BooksDto>builder()
                        .message("Book is not found!")
                        .code(-1)
                        .build());
    }


    @Override
    public ResponseDto<BooksDto> update(@Valid Integer entityId, BooksDto dto) {
        try {
            return this.booksRepository.findByBookId(entityId)
                    .map(books -> {
                        this.booksMapper.updateBooksFromDto(dto, books);
                        this.booksRepository.save(books);
                        return ResponseDto.<BooksDto>builder()
                                .success(true)
                                .message("OK")
                                .data(this.booksMapper.toDto(books))
                                .build();
                    })
                    .orElse(ResponseDto.<BooksDto>builder()
                            .code(-1)
                            .message("Book is not found!")
                            .build());

        } catch (Exception e) {
            return ResponseDto.<BooksDto>builder()
                    .code(-2)
                    .message(String.format("Book while saving error %s", e.getMessage()))
                    .build();
        }

    }

    @Override
    public ResponseDto<BooksDto> delete(@Valid Integer entityId) {
      try {
          return this.booksRepository.findByBookId(entityId)
                  .map(books -> {
                      this.booksRepository.delete(books);
                      return ResponseDto.<BooksDto>builder()
                              .success(true)
                              .message("OK")
                              .data(this.booksMapper.toDto(books))
                              .build();
                  })
                  .orElse(ResponseDto.<BooksDto>builder()
                          .message("Book is not found!")
                          .code(-1)
                          .build());
      }
      catch (Exception e){
          return ResponseDto.<BooksDto>builder()
                  .code(-2)
                  .message("Book while deleting error")
                  .build();
      }
    }

    public ResponseDto<List<BooksDto>> getAllBooks(){
        List<Books> list = this.booksRepository.findAll();
        if (list.isEmpty()) {
            return ResponseDto.<List<BooksDto>>builder()
                    .code(-1)
                    .message("Books are not found !")
                    .build();
        }
        return ResponseDto.<List<BooksDto>>builder()
                .success(true)
                .message("OK")
                .data(list.stream().map(this.booksMapper::toDto).toList())
                .build();
    }



}



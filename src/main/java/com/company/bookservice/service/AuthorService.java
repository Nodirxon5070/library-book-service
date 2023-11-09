package com.company.bookservice.service;

import com.company.bookservice.dto.ResponseDto;
import com.company.bookservice.dto.SimpleCRUD;
import com.company.bookservice.dto.request.AuthorRequestDto;
import com.company.bookservice.dto.response.AuthorResponseDto;
import com.company.bookservice.modul.Author;
import com.company.bookservice.repository.AuthorRepository;
import com.company.bookservice.service.mapper.AuthorMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public ResponseDto<AuthorResponseDto> create(@Valid AuthorRequestDto dto) {
        try {
            Author author = this.authorMapper.toEntity(dto);
            this.authorRepository.save(author);
            return ResponseDto.<AuthorResponseDto>builder()
                    .message("ok")
                    .success(true)
                    .data(this.authorMapper.toDto(author))
                    .build();
        } catch (Exception e) {

            return ResponseDto.<AuthorResponseDto>builder()
                    .message(String.format("Author save while error %s", e.getMessage()))
                    .code(-2)
                    .build();
        }
    }

    public ResponseDto<AuthorResponseDto> get(@Valid Integer entityId) {
        Optional<Author> optional = this.authorRepository.findByAuthorIdAndDeletedAtIsNull(entityId);
        if (optional.isEmpty()) {
            return ResponseDto.<AuthorResponseDto>builder()
                    .code(-1)
                    .message("author is not found")
                    .build();
        }
        return ResponseDto.<AuthorResponseDto>builder()
                .message("ok")
                .success(true)
                .data(this.authorMapper.toDtoWithBooks(optional.get()))
                .build();
    }

    public ResponseDto<AuthorResponseDto> update(@Valid Integer entityId, AuthorRequestDto dto) {
        try {
            return this.authorRepository.findByAuthorIdAndDeletedAtIsNull(entityId)
                    .map(author -> {
                        this.authorMapper.updateAuthorFromDto(dto,author);
                        author.setUpdatedAt(LocalDateTime.now());
                        this.authorRepository.save(author);
                        return ResponseDto.<AuthorResponseDto>builder()
                                .success(true)
                                .message("OK")
                                .data(this.authorMapper.toDto(author))
                                .build();
                    }).orElse(ResponseDto.<AuthorResponseDto>builder()
                            .code(-1)
                            .message(String.format("Author with %d :: id is not found",entityId))
                            .build());
        }catch (Exception e){
           return ResponseDto.<AuthorResponseDto>builder()
                    .code(-2)
                    .message(String.format("Author while updating error :: %s",e.getMessage()))
                    .build();
        }

    }

    public ResponseDto<AuthorResponseDto> delete(@Valid Integer entityId) {
        Optional<Author> optional = this.authorRepository.findByAuthorIdAndDeletedAtIsNull(entityId);
        if (optional.isEmpty()) {
            return ResponseDto.<AuthorResponseDto>builder()
                    .message("Author is not found")
                    .code(-2)
                    .build();
        }
        Author author = optional.get();
        this.authorRepository.save(author);
        author.setDeletedAt(LocalDateTime.now());
        return ResponseDto.<AuthorResponseDto>builder()
                .message("OK")
                .success(true)
                .data(this.authorMapper.toDto(author))
                .build();
    }


    public ResponseDto<List<AuthorResponseDto>> getAllAuthors(){
        List<Author> list = this.authorRepository.findAllByDeletedAtIsNull();
        if (list.isEmpty()) {
            return ResponseDto.<List<AuthorResponseDto>>builder()
                    .code(-1)
                    .message("Authors are not found!")
                    .build();
        }
        return ResponseDto.<List<AuthorResponseDto>>builder()
                .success(true)
                .message("OK")
                .data(list.stream().map(this.authorMapper::toDto).toList())
                .build();
    }
}

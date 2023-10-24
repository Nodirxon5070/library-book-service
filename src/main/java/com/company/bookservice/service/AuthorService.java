package com.company.bookservice.service;

import com.company.bookservice.dto.AuthorDto;
import com.company.bookservice.dto.ResponseDto;
import com.company.bookservice.dto.SimpleCRUD;
import com.company.bookservice.modul.Author;
import com.company.bookservice.repository.AuthorRepository;
import com.company.bookservice.service.mapper.AuthorMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService implements SimpleCRUD<Integer, AuthorDto> {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public ResponseDto<AuthorDto> create(@Valid AuthorDto dto) {
        try {
            Author author = this.authorMapper.toEntity(dto);
            this.authorRepository.save(author);
            return ResponseDto.<AuthorDto>builder()
                    .message("ok")
                    .success(true)
                    .data(this.authorMapper.toDto(author))
                    .build();
        } catch (Exception e) {

            return ResponseDto.<AuthorDto>builder()
                    .message(String.format("Author save while error %s", e.getMessage()))
                    .code(-2)
                    .build();
        }
    }

    @Override
    public ResponseDto<AuthorDto> get(@Valid Integer entityId) {
        Optional<Author> optional = this.authorRepository.findByAuthorIdAndDeletedAtIsNull(entityId);
        if (optional.isEmpty()) {
            return ResponseDto.<AuthorDto>builder()
                    .code(-1)
                    .message("author is not found")
                    .build();
        }
        return ResponseDto.<AuthorDto>builder()
                .message("ok")
                .success(true)
                .data(this.authorMapper.toDtoWithBooks(optional.get()))
                .build();
    }

    @Override
    public ResponseDto<AuthorDto> update(@Valid Integer entityId, AuthorDto dto) {
        Optional<Author> optional = this.authorRepository.findByAuthorIdAndDeletedAtIsNull(entityId);
        if (optional.isEmpty()) {
            return ResponseDto.<AuthorDto>builder()
                    .message("author is not found")
                    .code(-1)
                    .build();
        }
        try {
            Author author = optional.get();
            this.authorMapper.updateAuthorFromDto(dto, author);
            this.authorRepository.save(author);
            author.setUpdatedAt(LocalDateTime.now());
            return ResponseDto.<AuthorDto>builder()
                    .message("OK")
                    .data(this.authorMapper.toDto(author))
                    .success(true)
                    .build();
        } catch (Exception e) {
            return ResponseDto.<AuthorDto>builder()
                    .message(String.format("author save while error %s", e.getMessage()))
                    .code(-2)
                    .build();
        }

    }

    @Override
    public ResponseDto<AuthorDto> delete(@Valid Integer entityId) {
        Optional<Author> optional = this.authorRepository.findByAuthorIdAndDeletedAtIsNull(entityId);
        if (optional.isEmpty()) {
            return ResponseDto.<AuthorDto>builder()
                    .message("Author is not found")
                    .code(-2)
                    .build();
        }
        Author author = optional.get();
        this.authorRepository.save(author);
        author.setDeletedAt(LocalDateTime.now());
        return ResponseDto.<AuthorDto>builder()
                .message("OK")
                .success(true)
                .data(this.authorMapper.toDto(author))
                .build();
    }


    public ResponseDto<List<AuthorDto>> getAllAuthors(){
        List<Author> list = this.authorRepository.findAllByDeletedAtIsNull();
        if (list.isEmpty()) {
            return ResponseDto.<List<AuthorDto>>builder()
                    .code(-1)
                    .message("Authors are not found!")
                    .build();
        }
        return ResponseDto.<List<AuthorDto>>builder()
                .success(true)
                .message("OK")
                .data(list.stream().map(this.authorMapper::toDto).toList())
                .build();
    }
}

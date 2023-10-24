package com.company.bookservice.controller;

import com.company.bookservice.dto.AuthorDto;
import com.company.bookservice.dto.ResponseDto;
import com.company.bookservice.dto.SimpleCRUD;
import com.company.bookservice.service.AuthorService;
import com.company.bookservice.service.mapper.AuthorMapper;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@OpenAPIDefinition(
        tags = @Tag(name = "Author tag"),
        info = @Info(
                version = "v: 3.0.2",
                title = "Library Project",
                description = "Making changes on Author class",
                contact = @Contact(
                        name = "Library Project",
                        url = "https://t.me/xan_5070",
                        email = "nodirxon5070@gmail.com"
                ),
                license = @License(
                        name = "Library Project License",
                        url = "https://t.me/xan_5070"
                )
        ),
        servers = {@Server(url = "localhost:8081")}
)
@RestController
@RequestMapping(value = "author")
public record AuthorController(AuthorService authorService,
                               AuthorMapper authorMapper) implements SimpleCRUD<Integer, AuthorDto> {
    @Override
    @Operation(
            method = "Post",
            description = "Creating Author Entity",
            summary = "This method Creates Author",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content =@Content(
            mediaType = MediaType.APPLICATION_JSON_VALUE
    )
    )
    )
    @PostMapping(value = "/create")
    public ResponseDto<AuthorDto> create(@RequestBody AuthorDto dto) {
        return this.authorService.create(dto);
    }


    @Override
    @Operation(
            method = "Get",
            description = "Getting Author",
            summary = "This method Gets Author",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    )
    @GetMapping(value = "/get/{id}")
    public ResponseDto<AuthorDto> get(@PathVariable(value = "id") Integer entityId) {

        return this.authorService.get(entityId);
    }

    @Override
    @Operation(
            method = "Put",
            description = "Updating Author",
            summary = "This method Updates Author",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    )
    @PutMapping(value = "/update/{id}")
    public ResponseDto<AuthorDto> update(@PathVariable(value = "id") Integer entityId,
                                         @RequestBody AuthorDto dto) {
        return this.authorService.update(entityId, dto);
    }

    @Override
    @Operation(
            method = "Delete",
            description = "Deleting Author",
            summary = "This method Deletes Author",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    )
    @DeleteMapping(value = "/delete/{id}")
    public ResponseDto<AuthorDto> delete(@PathVariable(value = "id") Integer entityId) {
        return this.authorService.delete(entityId);
    }
    @GetMapping(value = "/get-all-authors")
    public ResponseDto<List<AuthorDto>> getAllAuthors(){
        return this.authorService.getAllAuthors();
    }
}

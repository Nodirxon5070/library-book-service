package com.company.bookservice.controller;


import com.company.bookservice.dto.BooksDto;
import com.company.bookservice.dto.ResponseDto;
import com.company.bookservice.dto.SimpleCRUD;
import com.company.bookservice.service.BooksService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@OpenAPIDefinition(
        tags = @Tag(name = "Books tag",
        description = "Control your Books"),
        info = @Info(title = "Library Project",
        version = "3.0.9",
        description = "Making changes on Books class",
        contact = @Contact(
                name = "Library Project",
                url = "https://t.me/xan_5070",
                email = "nodirxon5070@gmail.com"),
                license = @License(
                        name = "Library license",
                        url = "https://t.me/xan_5070"
                )

        )
)
@RestController
@RequestMapping(value = "books")
@RequiredArgsConstructor
public class BooksController implements SimpleCRUD<Integer,BooksDto> {


    private final BooksService booksService;

    @Override
    @Operation(
            method = "Post",
            summary = "This method creates Book",
            description = "Create book",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    )
    @PostMapping(value = "/create")
    public ResponseDto<BooksDto> create(@Valid @RequestBody BooksDto dto) {
        return this.booksService.create(dto);
    }

    @Override
    @Operation(
            method = "Get",
            summary = "This method Gets Book",
            description = "Get book",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    )
    @GetMapping(value = "/get/{id}")
    public ResponseDto<BooksDto> get(@PathVariable(value = "id") Integer id) {
        return this.booksService.get(id);
    }

    @Override
    @Operation(
            method = "Put",
            summary = "This method Updates Book",
            description = "Update book",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    )
    @PutMapping(value = "/update/{id}")
    public ResponseDto<BooksDto> update(@PathVariable(value = "id") Integer entityId,@RequestBody BooksDto dto) {
        return this.booksService.update(entityId,dto);
    }

    @Override
    @Operation(
            method = "Delete",
            summary = "This method Deletes Book",
            description = "Delete book",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    )
    @DeleteMapping(value = "/delete/{id}")
    public ResponseDto<BooksDto> delete(@PathVariable(value = "id") Integer entityId) {
        return this.booksService.delete(entityId);
    }

}

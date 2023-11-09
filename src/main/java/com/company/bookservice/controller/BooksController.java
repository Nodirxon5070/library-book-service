package com.company.bookservice.controller;


import com.company.bookservice.dto.BooksDto;
import com.company.bookservice.dto.ResponseDto;
import com.company.bookservice.dto.SimpleCRUD;
import com.company.bookservice.dto.request.BooksRequestDto;
import com.company.bookservice.dto.response.BooksResponseDto;
import com.company.bookservice.service.BooksService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.bookservice.constants.Constants.EXAMPLE_BOOK_NOT_FOUND;
import static com.company.bookservice.constants.Constants.EXAMPLE_BOOK_SUCCESS;
import static com.company.bookservice.constants.SimpleResponseDto.convertStatusCodeByData;


@RestController
@RequestMapping(value = "books")
@RequiredArgsConstructor
public class BooksController implements SimpleCRUD<Integer, BooksResponseDto, BooksRequestDto> {


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
    @ApiResponses(value={
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_BOOK_SUCCESS)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "404",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_BOOK_NOT_FOUND)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "400",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_BOOK_NOT_FOUND)
                            )
                    }

            )

    })
    @PostMapping(value = "/create")
    public ResponseEntity<ResponseDto<BooksResponseDto>> create(@Valid @RequestBody BooksRequestDto dto) {
        return convertStatusCodeByData(this.booksService.create(dto));
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
    @ApiResponses(value={
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_BOOK_SUCCESS)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "404",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_BOOK_NOT_FOUND)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "400",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_BOOK_NOT_FOUND)
                            )
                    }

            )

    })
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<ResponseDto<BooksResponseDto>> get(@PathVariable(value = "id") Integer id) {
        return convertStatusCodeByData(this.booksService.get(id));
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
    @ApiResponses(value={
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_BOOK_SUCCESS)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "404",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_BOOK_NOT_FOUND)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "400",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_BOOK_NOT_FOUND)
                            )
                    }

            )

    })
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ResponseDto<BooksResponseDto>> update(@PathVariable(value = "id") Integer entityId,@RequestBody BooksRequestDto dto) {
        return convertStatusCodeByData(this.booksService.update(entityId,dto));
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
    @ApiResponses(value={
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_BOOK_SUCCESS)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "404",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_BOOK_NOT_FOUND)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "400",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_BOOK_NOT_FOUND)
                            )
                    }

            )

    })
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<ResponseDto<BooksResponseDto>> delete(@PathVariable(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.booksService.delete(entityId));
    }

}

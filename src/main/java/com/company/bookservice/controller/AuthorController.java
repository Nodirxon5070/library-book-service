package com.company.bookservice.controller;

import com.company.bookservice.dto.AuthorDto;
import com.company.bookservice.dto.ResponseDto;
import com.company.bookservice.dto.SimpleCRUD;
import com.company.bookservice.dto.request.AuthorRequestDto;
import com.company.bookservice.dto.response.AuthorResponseDto;
import com.company.bookservice.service.AuthorService;
import com.company.bookservice.service.mapper.AuthorMapper;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.company.bookservice.constants.Constants.*;
import static com.company.bookservice.constants.SimpleResponseDto.convertStatusCodeByData;


@RestController
@RequestMapping(value = "author")
public record AuthorController(AuthorService authorService,
                               AuthorMapper authorMapper) implements SimpleCRUD<Integer, AuthorResponseDto, AuthorRequestDto> {
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
    @ApiResponses(value={
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_AUTHOR_SUCCESS)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "404",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_AUTHOR_NOT_FOUND)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "400",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_AUTHOR_NOT_FOUND)
                            )
                    }

            )

    })
    @PostMapping(value = "/create")
    public ResponseEntity<ResponseDto<AuthorResponseDto>> create(@RequestBody AuthorRequestDto dto) {
        return convertStatusCodeByData(this.authorService.create(dto));
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
    @ApiResponses(value={
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_AUTHOR_SUCCESS)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "404",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_AUTHOR_NOT_FOUND)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "400",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_AUTHOR_NOT_FOUND)
                            )
                    }

            )

    })
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<ResponseDto<AuthorResponseDto>> get(@PathVariable(value = "id") Integer entityId) {

        return convertStatusCodeByData(this.authorService.get(entityId));
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
    @ApiResponses(value={
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_AUTHOR_SUCCESS)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "404",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_AUTHOR_NOT_FOUND)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "400",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_AUTHOR_NOT_FOUND)
                            )
                    }

            )

    })
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ResponseDto<AuthorResponseDto>> update(@PathVariable(value = "id") Integer entityId,
                                         @RequestBody AuthorRequestDto dto) {
        return convertStatusCodeByData(this.authorService.update(entityId, dto));
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
    @ApiResponses(value={
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_AUTHOR_SUCCESS)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "404",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_AUTHOR_NOT_FOUND)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "400",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_AUTHOR_NOT_FOUND)
                            )
                    }

            )

    })
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<ResponseDto<AuthorResponseDto>> delete(@PathVariable(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.authorService.delete(entityId));
    }
    @GetMapping(value = "/get-all-authors")
    public ResponseEntity<ResponseDto<List<AuthorResponseDto>>> getAllAuthors(){
        return convertStatusCodeByData(this.authorService.getAllAuthors());
    }
}

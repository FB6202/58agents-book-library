package com._agents.java_book_library.controller;

import com._agents.java_book_library.payload.AuthorDto;
import com._agents.java_book_library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<String> addAuthor(@RequestBody AuthorDto authorDto) {
        return new ResponseEntity<>(authorService.addAuthor(authorDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.OK);
    }

    @GetMapping(value = "/{authorId}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable("authorId") Long authorId) {
        return new ResponseEntity<>(authorService.getAuthorById(authorId), HttpStatus.OK);
    }

    @PutMapping(value = "/{authorId}")
    public ResponseEntity<String> updateAuthor(@RequestBody AuthorDto authorDto,
                                               @PathVariable("authorId") Long authorId) {
        return new ResponseEntity<>(authorService.updateAuthor(authorDto, authorId), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{authorId}")
    public ResponseEntity<String> deleteAuthor(@PathVariable("authorId") Long authorId) {
        return new ResponseEntity<>(authorService.deleteAuthor(authorId), HttpStatus.OK);
    }

}

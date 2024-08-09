package com._agents.java_book_library.controller;

import com._agents.java_book_library.payload.BookDto;
import com._agents.java_book_library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody BookDto bookDto) {
        return new ResponseEntity<>(bookService.addBook(bookDto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping(path = "/available")
    public ResponseEntity<List<BookDto>> getAvailableBooks() {
        return new ResponseEntity<>(bookService.getAvailableBooks(), HttpStatus.OK);
    }

    @GetMapping(path = "/{bookId}")
    public ResponseEntity<BookDto> getBookById(@PathVariable("bookId") Long bookId) {
        return new ResponseEntity<>(bookService.getBookById(bookId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateBook(@RequestBody BookDto bookDto) {
        return new ResponseEntity<>(bookService.updateBook(bookDto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable("bookId") Long bookId) {
        return new ResponseEntity<>(bookService.deleteBook(bookId), HttpStatus.OK);
    }

}

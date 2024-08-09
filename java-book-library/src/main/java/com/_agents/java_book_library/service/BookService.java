package com._agents.java_book_library.service;

import com._agents.java_book_library.payload.BookDto;

import java.util.List;

public interface BookService {

    String addBook(BookDto bookDto);

    List<BookDto> getAllBooks();

    List<BookDto> getAvailableBooks();

    BookDto getBookById(Long bookId);

    String updateBook(BookDto bookDto);

    String deleteBook(Long bookId);

}

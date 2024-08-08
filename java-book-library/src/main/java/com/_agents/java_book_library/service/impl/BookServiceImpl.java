package com._agents.java_book_library.service.impl;

import com._agents.java_book_library.entity.Author;
import com._agents.java_book_library.entity.Book;
import com._agents.java_book_library.exception.types.ResourceAlreadyExistsException;
import com._agents.java_book_library.exception.types.ResourceNotFoundException;
import com._agents.java_book_library.payload.BookDto;
import com._agents.java_book_library.repo.AuthorRepository;
import com._agents.java_book_library.repo.BookRepository;
import com._agents.java_book_library.service.BookService;
import com._agents.java_book_library.util.DtoMapper;
import com._agents.java_book_library.util.EntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    public String addBook(BookDto bookDto) {
        Optional<Book> optBook = bookRepository.findByTitle(bookDto.getTitle());
        if (optBook.isPresent()) {
            throw new ResourceAlreadyExistsException("Book title already exists.");
        }

        Author author = authorRepository.findById(bookDto.getAuthorId()).orElseThrow(
                () -> new ResourceNotFoundException("Author", "ID", bookDto.getAuthorId())
        );
        Book book = EntityMapper.mapToBook(bookDto, author);
        bookRepository.save(book);
        log.info("New book added to DB: {}", book);
        return "Book saved successfully.";
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(DtoMapper::mapToBookDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> getAvailableBooks() {
        List<Book> books = bookRepository.findAll();
        List<Book> availableBooks = books.stream().filter(Book::getAvailable).toList();
        return availableBooks.stream()
                .map(DtoMapper::mapToBookDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookDto getBookById(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(
                () -> new ResourceNotFoundException("Book", "ID", bookId)
        );
        return DtoMapper.mapToBookDto(book);
    }

    @Override
    public String updateBook(BookDto bookDto, Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(
                () -> new ResourceNotFoundException("Book", "ID", bookId)
        );
        Author author = authorRepository.findById(bookDto.getAuthorId()).orElseThrow(
                () -> new ResourceNotFoundException("Author", "ID", bookDto.getAuthorId())
        );
        Book newBook = EntityMapper.mapToBook(bookDto, author);
        newBook.setId(book.getId());
        bookRepository.save(newBook);
        log.info("Book with ID '{}' updated successfully to: {}", bookId, newBook);
        return "Book updated successfully.";
    }

    @Override
    public String deleteBook(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(
                () -> new ResourceNotFoundException("Book", "ID", bookId)
        );
        bookRepository.delete(book);
        log.info("Book deleted with ID '{}'.", bookId);
        return "Book deleted successfully.";
    }

}

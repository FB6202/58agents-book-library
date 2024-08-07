package com._agents.java_book_library.service;

import com._agents.java_book_library.payload.AuthorDto;

import java.util.List;

public interface AuthorService {

    String addAuthor(AuthorDto authorDto);

    List<AuthorDto> getAllAuthors();

    AuthorDto getAuthorById(Long authorId);

    String updateAuthor(AuthorDto authorDto, Long authorId);

    String deleteAuthor(Long authorId);

}

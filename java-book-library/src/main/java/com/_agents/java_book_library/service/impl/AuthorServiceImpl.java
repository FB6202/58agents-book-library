package com._agents.java_book_library.service.impl;

import com._agents.java_book_library.entity.Author;
import com._agents.java_book_library.exception.ResourceNotFoundException;
import com._agents.java_book_library.payload.AuthorDto;
import com._agents.java_book_library.repo.AuthorRepository;
import com._agents.java_book_library.service.AuthorService;
import com._agents.java_book_library.util.DtoMapper;
import com._agents.java_book_library.util.EntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public String addAuthor(AuthorDto authorDto) {
        Author author = EntityMapper.mapToAuthor(authorDto);
        authorRepository.save(author);
        log.info("New author added to db: {}", author);
        return "Author saved successfully.";
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream()
                .map(DtoMapper::mapToAuthorDto)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDto getAuthorById(Long authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow(
                () -> new ResourceNotFoundException("Author", "ID", authorId)
        );
        return DtoMapper.mapToAuthorDto(author);
    }

    @Override
    public String updateAuthor(AuthorDto authorDto, Long authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow(
                () -> new ResourceNotFoundException("Author", "ID", authorId)
        );
        Author newAuthor = EntityMapper.mapToAuthor(authorDto);
        newAuthor.setId(author.getId());
        authorRepository.save(newAuthor);
        log.info("Author with ID '{}' updated successfully to: {}", authorId, newAuthor);
        return "Author updated successfully.";
    }

    @Override
    public String deleteAuthor(Long authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow(
                () -> new ResourceNotFoundException("Author", "ID", authorId)
        );
        authorRepository.delete(author);
        log.info("Author deleted with ID '{}'.", authorId);
        return "Author deleted successfully.";
    }

}

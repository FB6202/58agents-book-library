package com._agents.java_book_library.repo;

import com._agents.java_book_library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}

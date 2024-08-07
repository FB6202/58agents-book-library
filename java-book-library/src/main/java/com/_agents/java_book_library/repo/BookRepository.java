package com._agents.java_book_library.repo;

import com._agents.java_book_library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

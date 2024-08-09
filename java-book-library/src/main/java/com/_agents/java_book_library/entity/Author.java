package com._agents.java_book_library.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book> books;

    @Override // creating a custom and consistent toString design for the application logs + preventing stack overflow
    public String toString() {
        return String.format("(id: %s; name: %s, dateOfBirth: %s",
                id, name, dateOfBirth);
    }

}

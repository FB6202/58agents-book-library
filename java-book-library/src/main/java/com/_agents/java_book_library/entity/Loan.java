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
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate loanDate;
    private LocalDate returnDate;

    @OneToMany(mappedBy = "loan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book> books;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "member_id")
    private Member member;

}

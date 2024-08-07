package com._agents.java_book_library.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
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

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "book_id")
    private Book book;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "member_id")
    private Member member;

}

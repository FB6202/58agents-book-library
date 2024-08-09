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

    @OneToMany(mappedBy = "loan", fetch = FetchType.LAZY)
    private List<Book> books;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private Member member;

    @Override // creating a custom and consistent toString design for the application logs + preventing stack overflow
    public String toString() {
        return String.format("(id: %s; loanDate: %s; returnDate: %s, member: %s)",
                id, loanDate, returnDate, member.getUsername());
    }

}

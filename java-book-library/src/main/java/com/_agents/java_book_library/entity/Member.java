package com._agents.java_book_library.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String address;
    private String phoneNumber;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Loan> loans;

    @Override // creating a custom and consistent toString design for the application logs + preventing stack overflow
    public String toString() {
        return String.format("(id: %s; username: %s; email: %s; address: %s; phoneNumber: %s)",
                id, username, email, address, phoneNumber);
    }

}

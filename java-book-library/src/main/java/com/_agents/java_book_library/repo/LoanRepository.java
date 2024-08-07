package com._agents.java_book_library.repo;

import com._agents.java_book_library.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}

package com._agents.java_book_library.service;

import com._agents.java_book_library.payload.LoanDto;

import java.util.List;

public interface LoanService {

    String addLoan(LoanDto loanDto);

    List<LoanDto> getAllLoans();

    LoanDto getLoanById(Long loanId);

    String updateLoan(LoanDto loanDto, Long loanId);

    String deleteLoan(Long loanId);

}

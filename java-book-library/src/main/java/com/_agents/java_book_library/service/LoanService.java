package com._agents.java_book_library.service;

import com._agents.java_book_library.payload.LoanDto;

public interface LoanService {

    String loanBooks(LoanDto loanDto);

    String returnBooks(LoanDto loanDto);

}

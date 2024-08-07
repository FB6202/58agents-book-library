package com._agents.java_book_library.service;

import com._agents.java_book_library.payload.LoanDto;

public interface LoanService {

    String loanBook(LoanDto loanDto);

    String returnBook(LoanDto loanDto);

}

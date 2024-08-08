package com._agents.java_book_library.exception.types;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class LoanAmountException extends RuntimeException {

    public LoanAmountException(String message) {
        super(message);
    }

}

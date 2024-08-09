package com._agents.java_book_library.controller;

import com._agents.java_book_library.payload.LoanDto;
import com._agents.java_book_library.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PostMapping
    public ResponseEntity<String> addLoan(@RequestBody LoanDto loanDto) {
        return new ResponseEntity<>(loanService.addLoan(loanDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LoanDto>> getAllLoans() {
        return new ResponseEntity<>(loanService.getAllLoans(), HttpStatus.OK);
    }

    @GetMapping(path = "/{loanId}")
    public ResponseEntity<LoanDto> getLoanById(@PathVariable("loanId") Long loanId) {
        return new ResponseEntity<>(loanService.getLoanById(loanId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String> updateLoan(@RequestBody LoanDto loanDto) {
        return new ResponseEntity<>(loanService.updateLoan(loanDto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{loanId}")
    public ResponseEntity<String> deleteLoan(@PathVariable("loanId") Long loanId) {
        return new ResponseEntity<>(loanService.deleteLoan(loanId), HttpStatus.OK);
    }

}

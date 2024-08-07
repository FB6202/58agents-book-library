package com._agents.java_book_library.service.impl;

import com._agents.java_book_library.payload.LoanDto;
import com._agents.java_book_library.repo.BookRepository;
import com._agents.java_book_library.repo.LoanRepository;
import com._agents.java_book_library.repo.MemberRepository;
import com._agents.java_book_library.service.LoanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    @Override
    public String loanBook(LoanDto loanDto) {
        return null;
    }

    @Override
    public String returnBook(LoanDto loanDto) {
        return null;
    }

}

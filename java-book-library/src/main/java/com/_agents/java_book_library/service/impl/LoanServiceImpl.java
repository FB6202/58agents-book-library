package com._agents.java_book_library.service.impl;

import com._agents.java_book_library.entity.Book;
import com._agents.java_book_library.entity.Loan;
import com._agents.java_book_library.entity.Member;
import com._agents.java_book_library.exception.types.LoanAmountException;
import com._agents.java_book_library.exception.types.ResourceNotFoundException;
import com._agents.java_book_library.exception.types.ResourceUnavailableException;
import com._agents.java_book_library.payload.BookDto;
import com._agents.java_book_library.payload.LoanDto;
import com._agents.java_book_library.repo.BookRepository;
import com._agents.java_book_library.repo.LoanRepository;
import com._agents.java_book_library.repo.MemberRepository;
import com._agents.java_book_library.service.LoanService;
import com._agents.java_book_library.util.DtoMapper;
import com._agents.java_book_library.util.EntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;

    @Override
    public String addLoan(LoanDto loanDto) {
        Member member = checkMember(loanDto);
        List<Book> books = checkBooks(loanDto);
        Loan loan = EntityMapper.mapToLoan(loanDto, books, member);
        updateAvailability(books, false);
        loanRepository.save(loan);
        log.info("New loan added to DB: {}", loan);
        return "Loan saved successfully.";
    }

    @Override
    public List<LoanDto> getAllLoans() {
        List<Loan> loans = loanRepository.findAll();
        return loans.stream()
                .map(DtoMapper::mapToLoanDto)
                .collect(Collectors.toList());
    }

    @Override
    public LoanDto getLoanById(Long loanId) {
        Loan loan = loanRepository.findById(loanId).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "ID", loanId)
        );
        return DtoMapper.mapToLoanDto(loan);
    }

    @Override
    public String updateLoan(LoanDto loanDto, Long loanId) {
        Loan loan = loanRepository.findById(loanId).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "ID", loanId)
        );
        Member member = checkMember(loanDto);
        List<Book> books = checkBooks(loanDto);
        Loan newLoan = EntityMapper.mapToLoan(loanDto, books, member);
        newLoan.setId(loan.getId());
        loanRepository.save(newLoan);
        log.info("Loan with ID '{}' updated successfully to: {}", loanId, newLoan);
        return "Loan updated successfully.";
    }

    @Override
    public String deleteLoan(Long loanId) {
        Loan loan = loanRepository.findById(loanId).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "ID", loanId)
        );
        updateAvailability(loan.getBooks(), true);
        loanRepository.delete(loan);
        log.info("Loan deleted with ID '{}'.", loanId);
        return "Loan deleted successfully.";
    }

    private Member checkMember(LoanDto loanDto) {
        Member member = memberRepository.findById(loanDto.getMemberDto().getId()).orElseThrow(
                () -> new ResourceNotFoundException("Member", "ID", loanDto.getMemberDto().getId())
        );
        if (getLoanedBooks(member) + loanDto.getBooks().size() > 5) {
            throw new LoanAmountException("Your quota of loaned books (max. 5) is exhausted.");
        }
        return member;
    }

    private int getLoanedBooks(Member member) {
        int loanedBooks = 0;
        for (Loan loan : member.getLoans()) {
            loanedBooks += loan.getBooks().size();
        }
        return loanedBooks;
    }

    private List<Book> checkBooks(LoanDto loanDto) {
        List<BookDto> bookDtoList = loanDto.getBooks();
        return bookDtoList.stream()
                .map(book -> {
                    Book dbBook = bookRepository.findById(book.getId()).orElseThrow(
                            () -> new ResourceNotFoundException("Book", "ID", book.getId())
                    );
                    if (!dbBook.getAvailable()) {
                        throw new ResourceUnavailableException("Book '" + dbBook.getId() + "' currently unavailable.");
                    }
                    return dbBook;
                })
                .collect(Collectors.toList());
    }

    private void updateAvailability(List<Book> books, boolean available) {
        for (Book book : books) {
            book.setAvailable(available);
        }
    }

}

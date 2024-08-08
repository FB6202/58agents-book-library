package com._agents.java_book_library.util;

import com._agents.java_book_library.entity.Author;
import com._agents.java_book_library.entity.Book;
import com._agents.java_book_library.entity.Loan;
import com._agents.java_book_library.entity.Member;
import com._agents.java_book_library.payload.AuthorDto;
import com._agents.java_book_library.payload.BookDto;
import com._agents.java_book_library.payload.LoanDto;
import com._agents.java_book_library.payload.MemberDto;

import java.util.List;

public class EntityMapper {

    public static Author mapToAuthor(AuthorDto authorDto) {
        return Author.builder()
                .name(authorDto.getName())
                .dateOfBirth(authorDto.getDateOfBirth())
                .build();
    }

    public static Book mapToBook(BookDto bookDto, Author author) {
        return Book.builder()
                .title(bookDto.getTitle())
                .genre(bookDto.getGenre())
                .price(bookDto.getPrice())
                .available(bookDto.getAvailable())
                .author(author)
                .build();
    }

    public static Loan mapToLoan(LoanDto loanDto, List<Book> books, Member member) {
        return Loan.builder()
                .loanDate(loanDto.getLoanDate())
                .returnDate(loanDto.getReturnDate())
                .books(books)
                .member(member)
                .build();
    }

    public static Member mapToMember(MemberDto memberDto) {
        return Member.builder()
                .username(memberDto.getUsername())
                .email(memberDto.getEmail())
                .address(memberDto.getAddress())
                .phoneNumber(memberDto.getPhoneNumber())
                .build();
    }

}

package com._agents.java_book_library.util;

import com._agents.java_book_library.entity.Author;
import com._agents.java_book_library.entity.Book;
import com._agents.java_book_library.entity.Loan;
import com._agents.java_book_library.entity.Member;
import com._agents.java_book_library.payload.AuthorDto;
import com._agents.java_book_library.payload.BookDto;
import com._agents.java_book_library.payload.LoanDto;
import com._agents.java_book_library.payload.MemberDto;

public class DtoMapper {

    public static AuthorDto mapToAuthorDto(Author author) {
        return AuthorDto.builder()
                .id(author.getId())
                .name(author.getName())
                .dateOfBirth(author.getDateOfBirth())
                .build();
    }

    public static BookDto mapToBookDto(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .genre(book.getGenre())
                .price(book.getPrice())
                .available(book.getAvailable())
                .authorId(book.getAuthor().getId())
                .build();
    }

    public static LoanDto mapToLoanDto(Loan loan) {
        return LoanDto.builder()
                .id(loan.getId())
                .loanDate(loan.getLoanDate())
                .returnDate(loan.getReturnDate())
                .books(loan.getBooks().stream().map(DtoMapper::mapToBookDto).toList())
                .memberDto(mapToMemberDto(loan.getMember()))
                .build();
    }

    public static MemberDto mapToMemberDto(Member member) {
        return MemberDto.builder()
                .id(member.getId())
                .username(member.getUsername())
                .email(member.getEmail())
                .address(member.getAddress())
                .phoneNumber(member.getPhoneNumber())
                .build();
    }

}

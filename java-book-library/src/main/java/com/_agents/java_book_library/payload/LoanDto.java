package com._agents.java_book_library.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanDto {

    private Long id;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private List<BookDto> books;
    private MemberDto memberDto;

}

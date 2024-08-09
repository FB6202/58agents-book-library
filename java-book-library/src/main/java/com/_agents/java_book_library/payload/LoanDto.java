package com._agents.java_book_library.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Loan's loan date attribute should not be null!")
    @NotBlank(message = "Loan's loan date attribute should not be blank!")
    private LocalDate loanDate;

    @NotNull(message = "Loan's return date attribute should not be null!")
    @NotBlank(message = "Loan's return date attribute should not be blank!")
    private LocalDate returnDate;

    @NotNull(message = "Loan's books list should not be null!")
    @NotEmpty(message = "Loan's books list should at least contain one item!")
    private List<BookDto> books;

    @NotNull(message = "Loan should belong to a member of the library!")
    private MemberDto memberDto;

}

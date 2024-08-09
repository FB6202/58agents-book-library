package com._agents.java_book_library.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorDto {

    private Long id;

    @NotNull(message = "Author's name attribute should not be null!")
    @NotBlank(message = "Author's name attribute should not be blank!")
    private String name;

    @NotNull(message = "Author's date of birth attribute should not be null!")
    @NotBlank(message = "Author's name attribute should not be blank!")
    private LocalDate dateOfBirth;

}

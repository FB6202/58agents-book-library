package com._agents.java_book_library.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {

    private Long id;

    @NotNull(message = "Book's title attribute should not be null!")
    @NotBlank(message = "Book's title attribute should not be blank!")
    private String title;

    @NotNull(message = "Book's genre attribute should not be null!")
    @NotBlank(message = "Book's genre attribute should not be blank!")
    private String genre;

    @NotNull(message = "Book's price attribute should not be null!")
    private Double price;

    @NotNull(message = "Book's available attribute should not be null!")
    private Boolean available;

    @NotNull(message = "Book's author id attribute should not be null!")
    private Long authorId;

}

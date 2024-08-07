package com._agents.java_book_library.payload;

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
    private String title;
    private String genre;
    private Double price;
    private Boolean available;
    private Long authorId;

}

package com._agents.java_book_library.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {

    private Long id;

    @NotNull(message = "Member's username attribute should not be null!")
    @NotBlank(message = "Member's username attribute should not be blank!")
    private String username;

    @NotNull(message = "Member's username attribute should not be null!")
    @NotBlank(message = "Member's username attribute should not be blank!")
    @Email(message = "Member's email attribute should be a valid email address!")
    private String email;

    @NotNull(message = "Member's address attribute should not be null!")
    @NotBlank(message = "Member's address attribute should not be blank!")
    private String address;

    @NotNull(message = "Member's phone number attribute should not be null!")
    @NotBlank(message = "Member's phone number attribute should not be blank!")
    @Size(min = 5, max = 25, message = "Member's phone number attribute should be between 5 and 25 characters long!")
    private String phoneNumber;

}

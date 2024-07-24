package com.ecommerce.springboot.api.model;

import jakarta.validation.constraints.*;
import lombok.Getter;


@Getter
public class RegistrationBody {
    private Long customer_id;
    @NotNull
    @NotBlank
    @Size( min = 6, max = 255 )
    private String username;
    @NotNull
    @NotBlank
    private String firstname;
    @NotNull
    @NotBlank
    private String lastname;
    @NotNull
    @NotBlank
    @Email
    private String email;
    @Size (min = 6, max= 32)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$")
    @NotNull
    @NotBlank
    private String password;
}

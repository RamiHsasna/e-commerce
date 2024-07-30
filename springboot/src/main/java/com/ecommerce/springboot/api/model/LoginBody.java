package com.ecommerce.springboot.api.model;

import jakarta.validation.constraints.*;

public class LoginBody {

    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    private String password;

    public @NotNull @NotBlank String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
}

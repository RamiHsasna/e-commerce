package com.ecommerce.springboot.api.model;

import jakarta.validation.constraints.*;

public class LoginBody {

    @NotNull
    @NotBlank
    private String username;
    @NotNull
    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

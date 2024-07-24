package com.ecommerce.springboot.api.model;

import lombok.Getter;


@Getter
public class RegistrationBody {
    private Long customer_id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

}

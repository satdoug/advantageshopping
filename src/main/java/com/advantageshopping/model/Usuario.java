package com.advantageshopping.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    private String userName;
    private String email;
    private String password;
    private String fisrtName;
    private String lastName;
    private String phone;
    private String country;
    private String City;
    private String address;
    private String state;
    private String postal;
}

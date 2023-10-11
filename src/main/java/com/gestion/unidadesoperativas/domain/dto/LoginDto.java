package com.gestion.unidadesoperativas.domain.dto;

import lombok.Data;

@Data
public class LoginDto {

    private int id;
    private String username;
    public String email;
    private String password;
    private String roles;
}

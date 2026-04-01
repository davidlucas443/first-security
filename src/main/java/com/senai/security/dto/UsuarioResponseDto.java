package com.senai.security.dto;

import com.senai.security.entities.enums.Roles;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UsuarioResponseDto {

    private Long id;

    private String nome;

    private String email;
}

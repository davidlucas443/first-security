package com.senai.security.service;

import com.senai.security.dto.UsuarioRequestDto;
import com.senai.security.dto.UsuarioResponseDto;
import com.senai.security.entities.Usuario;
import com.senai.security.entities.enums.Roles;
import com.senai.security.repositories.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public UsuarioResponseDto criarUsuario(UsuarioRequestDto dto){

        Usuario user = new Usuario();
        user.setNome(dto.getNome());
        user.setEmail(dto.getEmail());
        user.setSenha(passwordEncoder.encode(dto.getSenha()));
        user.setRole(Roles.ROLE_USER);

        Usuario savedUser = usuarioRepository.save(user);

        UsuarioResponseDto response = new UsuarioResponseDto();
        response.setId(savedUser.getId());
        response.setNome(savedUser.getNome());
        response.setEmail(savedUser.getEmail());

        return response;
    }

}

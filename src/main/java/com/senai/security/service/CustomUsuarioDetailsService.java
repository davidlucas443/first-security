package com.senai.security.service;

import com.senai.security.entities.Usuario;
import com.senai.security.repositories.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUsuarioDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public CustomUsuarioDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario nao encontrado para o email: " + email);
        }

        String role = user.getRole() == null ? "USER" : user.getRole().name().replace("ROLE_", "");
        return User.builder()
                .username(user.getEmail())
                .password(user.getSenha())
                .roles(role)
                .build()

                ;
    }
}

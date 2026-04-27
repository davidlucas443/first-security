package com.senai.security.controller;
import com.senai.security.dto.UsuarioRequestDto;
import com.senai.security.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/users")
    public ResponseEntity criarUsuario (@Valid @RequestBody UsuarioRequestDto dto){
        return ResponseEntity.ok(usuarioService.criarUsuario(dto));
    }
    @GetMapping("/admin")
    public String admin(){
        return "Acesso Admin";
    }

}

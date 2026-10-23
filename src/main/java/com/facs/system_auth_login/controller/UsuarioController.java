package com.facs.system_auth_login.controller;

import com.facs.system_auth_login.entity.UsuarioEntity;
import com.facs.system_auth_login.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/user")
@RestController
public class UsuarioController {
    private final UsuarioService usuarioService;

    UsuarioController (UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<UsuarioEntity>> listaUsuarios(){
        return ResponseEntity.ok(usuarioService.buscarUsuarios());
    }

    @GetMapping(path = "/find")
    public ResponseEntity <List<UsuarioEntity>> buscarUsuario(@RequestParam String nome){
        return ResponseEntity.ok(usuarioService.procurarUsuario(nome));
    }

}

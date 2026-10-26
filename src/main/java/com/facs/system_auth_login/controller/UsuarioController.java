package com.facs.system_auth_login.controller;

import com.facs.system_auth_login.dto.request.ProcurarUsuarioRequestDTO;
import com.facs.system_auth_login.dto.response.ProcurarUsuarioResponseDTO;
import com.facs.system_auth_login.entity.UsuarioEntity;
import com.facs.system_auth_login.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Page<UsuarioEntity>> listaUsuarios(Pageable pageable){
        return ResponseEntity.ok(usuarioService.buscarUsuarios(pageable));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<ProcurarUsuarioResponseDTO>> buscarUsuario(@Valid ProcurarUsuarioRequestDTO procurarUsuarioRequestDTO){
        List<ProcurarUsuarioResponseDTO> listaResultado = usuarioService.procurarUsuario(procurarUsuarioRequestDTO);

        return ResponseEntity.status(HttpStatus.OK).body(listaResultado);
    }

}

package com.facs.system_auth_login.service;

import com.facs.system_auth_login.dto.request.ProcurarUsuarioRequestDTO;
import com.facs.system_auth_login.dto.response.ProcurarUsuarioResponseDTO;
import com.facs.system_auth_login.entity.UsuarioEntity;
import com.facs.system_auth_login.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
        private final UsuarioRepository usuarioRepository;

        UsuarioService (UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

        public List<ProcurarUsuarioResponseDTO> procurarUsuario(ProcurarUsuarioRequestDTO procurarUsuarioRequestDTO){
        List<UsuarioEntity> usuarioBuscado = usuarioRepository.findByNome(procurarUsuarioRequestDTO.nome());

        return usuarioBuscado.stream()
                .map(u -> new ProcurarUsuarioResponseDTO(u.getNome(), u.getEmail(), u.getDataNascimento()))
                .toList();
    }

    public List<UsuarioEntity> buscarUsuarios(){
        return usuarioRepository.findAll();
    }
}

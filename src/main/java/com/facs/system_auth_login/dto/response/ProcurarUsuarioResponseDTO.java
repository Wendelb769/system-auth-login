package com.facs.system_auth_login.dto.response;

import java.time.LocalDate;

public record ProcurarUsuarioResponseDTO(
        String nome,
        String email,
        LocalDate dataNascimento){}


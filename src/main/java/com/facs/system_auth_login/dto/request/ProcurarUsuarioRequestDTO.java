package com.facs.system_auth_login.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ProcurarUsuarioRequestDTO(
        @NotBlank(message = "Digite um nome na barra de pesquisa!")
        String nome
) {
}

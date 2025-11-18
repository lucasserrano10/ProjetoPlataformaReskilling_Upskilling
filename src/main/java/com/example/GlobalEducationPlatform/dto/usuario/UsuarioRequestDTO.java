package com.example.GlobalEducationPlatform.dto.usuario;

import java.time.LocalDate;

public record UsuarioRequestDTO(
        String nome,
        String email,
        String areaAtuacao,
        String nivelCarreira,
        LocalDate dataCadastro
) {}
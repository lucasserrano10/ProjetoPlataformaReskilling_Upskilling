package com.example.GlobalEducationPlatform.dto.trilha;

public record TrilhaRequestDTO(
        String nome,
        String descricao,
        String nivel,
        Integer cargaHoraria,
        String focoPrincipal
) {}

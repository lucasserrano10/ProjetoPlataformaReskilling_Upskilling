package com.example.GlobalEducationPlatform.dto.competencia;

import jakarta.validation.constraints.*;

public record CompetenciaRequestDTO(

        @NotBlank(message = "O nome é obrigatório")
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
        String nome,

        @Size(max = 100, message = "A categoria deve ter no máximo 100 caracteres")
        String categoria,

        @Size(max = 500, message = "A descrição pode ter no máximo 500 caracteres")
        String descricao
) {}


package com.example.GlobalEducationPlatform.dto.trilha;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TrilhaRequestDTO(

        @NotBlank(message = "O nome é obrigatório")
        @Size(max = 150, message = "O nome deve ter no máximo 150 caracteres")
        String nome,

        @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres")
        String descricao,

        @NotBlank(message = "O nível é obrigatório")
        @Size(max = 50, message = "O nível deve ter no máximo 50 caracteres")
        String nivel,

        @NotNull(message = "A carga horária é obrigatória")
        @Min(value = 1, message = "A carga horária deve ser no mínimo 1 hora")
        Integer cargaHoraria,

        @Size(max = 100, message = "O foco principal deve ter no máximo 100 caracteres")
        String focoPrincipal
) {}

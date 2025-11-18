package com.example.GlobalEducationPlatform.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record UsuarioRequestDTO(

        @NotBlank(message = "O nome é obrigatório")
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
        String nome,

        @NotBlank(message = "O email é obrigatório")
        @Email(message = "O email deve ser válido")
        @Size(max = 150, message = "O email deve ter no máximo 150 caracteres")
        String email,

        @Size(max = 100, message = "A área de atuação deve ter no máximo 100 caracteres")
        String areaAtuacao,

        @Size(max = 50, message = "O nível de carreira deve ter no máximo 50 caracteres")
        String nivelCarreira,

        @NotNull(message = "A data de cadastro é obrigatória")
        LocalDate dataCadastro
) {}
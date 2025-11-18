package com.example.GlobalEducationPlatform.model;

import com.example.GlobalEducationPlatform.dto.trilha.TrilhaRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "trilhas")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trilha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false, length = 50)
    private String nivel;

    @Column(nullable = false)
    private Integer cargaHoraria;

    @Column(length = 100)
    private String focoPrincipal;

    public Trilha(TrilhaRequestDTO dto) {
        this.nome = dto.nome();
        this.descricao = dto.descricao();
        this.nivel = dto.nivel();
        this.cargaHoraria = dto.cargaHoraria();
        this.focoPrincipal = dto.focoPrincipal();
    }

}

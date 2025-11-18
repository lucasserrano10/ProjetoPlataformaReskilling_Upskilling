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

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNivel() {
        return nivel;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public String getFocoPrincipal() {
        return focoPrincipal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setFocoPrincipal(String focoPrincipal) {
        this.focoPrincipal = focoPrincipal;
    }

    public Trilha() {
    }
}

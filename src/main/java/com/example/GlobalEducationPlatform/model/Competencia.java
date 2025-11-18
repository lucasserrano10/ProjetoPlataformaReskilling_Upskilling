package com.example.GlobalEducationPlatform.model;

import com.example.GlobalEducationPlatform.dto.competencia.CompetenciaRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "competencias")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Competencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 100)
    private String categoria;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    public Competencia(CompetenciaRequestDTO dto) {
        this.nome = dto.nome();
        this.categoria = dto.categoria();
        this.descricao = dto.descricao();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Competencia() {
    }
}

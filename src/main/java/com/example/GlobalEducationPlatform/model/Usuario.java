package com.example.GlobalEducationPlatform.model;

import com.example.GlobalEducationPlatform.dto.usuario.UsuarioRequestDTO;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(length = 100)
    private String areaAtuacao;

    @Column(length = 50)
    private String nivelCarreira;

    @Column(nullable = false)
    private LocalDate dataCadastro;

    public Usuario(UsuarioRequestDTO dto) {
        this.nome = dto.nome();
        this.email = dto.email();
        this.areaAtuacao = dto.areaAtuacao();
        this.nivelCarreira = dto.nivelCarreira();
        this.dataCadastro = dto.dataCadastro();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public String getNivelCarreira() {
        return nivelCarreira;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public void setNivelCarreira(String nivelCarreira) {
        this.nivelCarreira = nivelCarreira;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Usuario() {
    }
}
package com.example.GlobalEducationPlatform.model;

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
}

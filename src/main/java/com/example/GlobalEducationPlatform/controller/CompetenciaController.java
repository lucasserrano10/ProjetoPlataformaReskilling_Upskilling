package com.example.GlobalEducationPlatform.controller;

import com.example.GlobalEducationPlatform.dto.competencia.CompetenciaRequestDTO;
import com.example.GlobalEducationPlatform.dto.competencia.CompetenciaResponseDTO;
import com.example.GlobalEducationPlatform.service.CompetenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competencias")
public class CompetenciaController {

    private final CompetenciaService service;

    public CompetenciaController(CompetenciaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CompetenciaResponseDTO> criar(@RequestBody CompetenciaRequestDTO dto) {
        var resposta = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @GetMapping
    public ResponseEntity<List<CompetenciaResponseDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompetenciaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompetenciaResponseDTO> atualizar(@PathVariable Long id, @RequestBody CompetenciaRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
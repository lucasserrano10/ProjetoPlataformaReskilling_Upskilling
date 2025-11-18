package com.example.GlobalEducationPlatform.controller;

import com.example.GlobalEducationPlatform.dto.trilha.TrilhaRequestDTO;
import com.example.GlobalEducationPlatform.dto.trilha.TrilhaResponseDTO;
import com.example.GlobalEducationPlatform.service.TrilhaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trilhas")
public class TrilhaController {

    private final TrilhaService service;

    public TrilhaController(TrilhaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TrilhaResponseDTO> criar(@Valid @RequestBody TrilhaRequestDTO dto) {
        var resposta = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @GetMapping
    public ResponseEntity<List<TrilhaResponseDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrilhaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrilhaResponseDTO> atualizar(@PathVariable Long id,@Valid @RequestBody TrilhaRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}


package com.example.GlobalEducationPlatform.service;

import com.example.GlobalEducationPlatform.dto.trilha.TrilhaRequestDTO;
import com.example.GlobalEducationPlatform.dto.trilha.TrilhaResponseDTO;
import com.example.GlobalEducationPlatform.model.Trilha;
import com.example.GlobalEducationPlatform.repository.TrilhaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrilhaService {

    private final TrilhaRepository repository;

    public TrilhaService(TrilhaRepository repository) {
        this.repository = repository;
    }

    public TrilhaResponseDTO criar(TrilhaRequestDTO dto) {
        Trilha trilha = new Trilha(dto);
        repository.save(trilha);

        return new TrilhaResponseDTO(
                trilha.getId(),
                trilha.getNome(),
                trilha.getDescricao(),
                trilha.getNivel(),
                trilha.getCargaHoraria(),
                trilha.getFocoPrincipal()
        );
    }

    public List<TrilhaResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(t -> new TrilhaResponseDTO(
                        t.getId(), t.getNome(), t.getDescricao(),
                        t.getNivel(), t.getCargaHoraria(), t.getFocoPrincipal()
                )).toList();
    }

    public TrilhaResponseDTO buscarPorId(Long id) {
        Trilha trilha = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trilha não encontrada"));

        return new TrilhaResponseDTO(
                trilha.getId(),
                trilha.getNome(),
                trilha.getDescricao(),
                trilha.getNivel(),
                trilha.getCargaHoraria(),
                trilha.getFocoPrincipal()
        );
    }

    public TrilhaResponseDTO atualizar(Long id, TrilhaRequestDTO dto) {
        Trilha trilha = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trilha não encontrada"));

        trilha.setNome(dto.nome());
        trilha.setDescricao(dto.descricao());
        trilha.setNivel(dto.nivel());
        trilha.setCargaHoraria(dto.cargaHoraria());
        trilha.setFocoPrincipal(dto.focoPrincipal());

        repository.save(trilha);

        return new TrilhaResponseDTO(
                trilha.getId(), trilha.getNome(), trilha.getDescricao(),
                trilha.getNivel(), trilha.getCargaHoraria(), trilha.getFocoPrincipal()
        );
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

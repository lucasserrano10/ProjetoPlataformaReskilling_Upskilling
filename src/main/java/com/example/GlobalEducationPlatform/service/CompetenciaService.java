package com.example.GlobalEducationPlatform.service;

import com.example.GlobalEducationPlatform.dto.competencia.CompetenciaRequestDTO;
import com.example.GlobalEducationPlatform.dto.competencia.CompetenciaResponseDTO;
import com.example.GlobalEducationPlatform.model.Competencia;
import com.example.GlobalEducationPlatform.repository.CompetenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenciaService {

    private final CompetenciaRepository repository;

    public CompetenciaService(CompetenciaRepository repository) {
        this.repository = repository;
    }

    public CompetenciaResponseDTO criar(CompetenciaRequestDTO dto) {
        Competencia c = new Competencia(dto);
        repository.save(c);

        return new CompetenciaResponseDTO(
                c.getId(), c.getNome(), c.getCategoria(), c.getDescricao()
        );
    }

    public List<CompetenciaResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(c -> new CompetenciaResponseDTO(
                        c.getId(), c.getNome(), c.getCategoria(), c.getDescricao()
                )).toList();
    }

    public CompetenciaResponseDTO buscarPorId(Long id) {
        Competencia c = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Competência não encontrada"));

        return new CompetenciaResponseDTO(
                c.getId(), c.getNome(), c.getCategoria(), c.getDescricao()
        );
    }

    public CompetenciaResponseDTO atualizar(Long id, CompetenciaRequestDTO dto) {
        Competencia c = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Competência não encontrada"));

        c.setNome(dto.nome());
        c.setCategoria(dto.categoria());
        c.setDescricao(dto.descricao());

        repository.save(c);

        return new CompetenciaResponseDTO(
                c.getId(), c.getNome(), c.getCategoria(), c.getDescricao()
        );
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

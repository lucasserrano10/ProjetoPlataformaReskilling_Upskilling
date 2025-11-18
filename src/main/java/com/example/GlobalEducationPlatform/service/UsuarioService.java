package com.example.GlobalEducationPlatform.service;

import com.example.GlobalEducationPlatform.dto.usuario.UsuarioRequestDTO;
import com.example.GlobalEducationPlatform.dto.usuario.UsuarioResponseDTO;
import com.example.GlobalEducationPlatform.model.Usuario;
import com.example.GlobalEducationPlatform.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario(dto);
        repository.save(usuario);
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getAreaAtuacao(),
                usuario.getNivelCarreira(),
                usuario.getDataCadastro()
        );
    }

    public List<UsuarioResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(u -> new UsuarioResponseDTO(
                        u.getId(), u.getNome(), u.getEmail(),
                        u.getAreaAtuacao(), u.getNivelCarreira(),
                        u.getDataCadastro()
                ))
                .toList();
    }

    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getAreaAtuacao(),
                usuario.getNivelCarreira(),
                usuario.getDataCadastro()
        );
    }

    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setAreaAtuacao(dto.areaAtuacao());
        usuario.setNivelCarreira(dto.nivelCarreira());
        usuario.setDataCadastro(dto.dataCadastro());

        repository.save(usuario);

        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getAreaAtuacao(),
                usuario.getNivelCarreira(),
                usuario.getDataCadastro()
        );
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}

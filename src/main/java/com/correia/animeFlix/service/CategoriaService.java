package com.correia.animeFlix.service;

import com.correia.animeFlix.domain.dto.CategoriaDTO;
import com.correia.animeFlix.domain.model.Categoria;
import com.correia.animeFlix.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    // Buscar Categoria por ID
    public CategoriaDTO getCategoriasId(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        return CategoriaDTO.fromEntity(categoria);
    }

    // Buscar todas as Categorias
    public List<CategoriaDTO> getCategorias() {
        return categoriaRepository.findAll()
                .stream()
                .map(CategoriaDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public List<CategoriaDTO> getCategoriasOrdenadas() {
        //List<Categoria> categorias = categoriaRepository.findAllByOrderByNomeAsc();
        return categoriaRepository.findAllByOrderByNomeAsc()
                .stream()
                .map(CategoriaDTO::fromEntity)
                .collect(Collectors
                        .toList());
    }

    public List<CategoriaDTO> getRandomCategorias() {
        return categoriaRepository.findRandomCategorias()
                .stream()
                .map(CategoriaDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // Criar a Categoria
    // Criar uma nova Categoria ou reaproveitar se já existir
    public CategoriaDTO create(CategoriaDTO categoriaDTO) {
        String nomeCategoria = categoriaDTO.getNome().toUpperCase();

        Categoria categoria = categoriaRepository.findByNome(nomeCategoria)
                .orElseGet(() -> categoriaDTO.toEntity());

        // adiciona apenas novos cards
        categoriaDTO.getCard().forEach(cardDTO -> {
            boolean exists = categoria.getCard().stream()
                    .anyMatch(c -> c.getNome().equalsIgnoreCase(cardDTO.getNome()));
            if (!exists) {
                categoria.getCard().add(cardDTO.toEntity());
            }
        });

        categoria.setNome(nomeCategoria); // garante uppercase
        Categoria saved = categoriaRepository.save(categoria);
        return CategoriaDTO.fromEntity(saved);
    }


    public CategoriaDTO update(Long id, CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaDTO.toEntity();
        categoria.setId(id);
        Categoria saved = categoriaRepository.save(categoria);
        return CategoriaDTO.fromEntity(saved);
    }
    public CategoriaDTO delete(Long id){
        CategoriaDTO categoriaDTO=getCategoriasId(id);
        categoriaRepository.deleteById(id);
        return categoriaDTO;
    }

}

package com.correia.animeFlix.service;

import com.correia.animeFlix.domain.dto.CardDTO;
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

    public List<CategoriaDTO> getCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream().map(this::toDTO).collect(Collectors.toList());
    }

    private CategoriaDTO toDTO(Categoria categoria) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setCategoria(categoria.getNome());
        categoriaDTO.setCard(categoria.getCard().stream()
                .map(card -> new CardDTO(card.getNome(), card.getImage(), card.getLink()))
                .collect(Collectors.toList()));
        return categoriaDTO;
    }

    public CategoriaDTO create(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria();
        categoria.setNome(categoriaDTO.getNome());
        categoria.setCard(categoriaDTO.cardDTO(categoriaDTO.getCard()));
        categoriaRepository.save(categoria);
        return null;
    }
}


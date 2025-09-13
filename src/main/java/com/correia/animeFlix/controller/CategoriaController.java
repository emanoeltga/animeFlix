package com.correia.animeFlix.controller;

import com.correia.animeFlix.domain.dto.CategoriaDTO;
import com.correia.animeFlix.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaDTO> getCategorias() {
        return categoriaService.getCategoriasOrdenadas();
    }

    @PostMapping
    public CategoriaDTO createCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        // Implementar a criação de categoria
        categoriaService.create(categoriaDTO);
        return categoriaDTO;
    }

    @PutMapping("/{id}")
    public CategoriaDTO updateCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        // Implementar atualização de categoria
        //categoriaService.update(id, categoriaDTO);
        return categoriaService.update(id, categoriaDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Long id) {
        // Implementar remoção de categoria
        categoriaService.delete(id);
    }
}


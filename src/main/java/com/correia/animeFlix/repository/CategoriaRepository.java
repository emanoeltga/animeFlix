package com.correia.animeFlix.repository;

import com.correia.animeFlix.domain.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Retorna todas as categorias ordenadas pelo campo "nome" (ascendente)
    List<Categoria> findAllByOrderByNomeAsc();
    @Query(value = "SELECT * FROM categoria ORDER BY RAND() LIMIT 2", nativeQuery = true)
    List<Categoria> findRandomCategorias();

    Optional<Categoria> findByNome(String nome);
}

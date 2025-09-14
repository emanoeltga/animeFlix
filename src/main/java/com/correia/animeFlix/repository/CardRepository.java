package com.correia.animeFlix.repository;

import com.correia.animeFlix.domain.dto.CardDTO;
import com.correia.animeFlix.domain.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    @Query(value = "SELECT new com.correia.animeFlix.domain.dto.CardDTO(c.nome, c.image, c.link)"   +
                       "FROM Card c ", nativeQuery = true)
    public List<CardDTO> findCardRandom();


}

package com.correia.animeFlix.domain.dto;


import com.correia.animeFlix.domain.model.Card;
import com.correia.animeFlix.domain.model.Categoria;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDTO {

    private String nome;
    private List<CardDTO> card;

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setCategoria(String nome) {
        this.nome = nome;
    }

    public List<CardDTO> getCard() {
        return card;
    }

    public void setCard(List<CardDTO> card) {
        this.card = card;
    }

    public List<Card> cardDTO(List<CardDTO> dtos){
        List<Card> lista = new ArrayList<>();
        for (CardDTO cardDTO:dtos) {
            Card card = new Card();
            card.setNome(cardDTO.getNome());
            card.setImage(cardDTO.getImage());
            card.setLink(cardDTO.getLink());
            lista.add(card);
        }
        return lista;
    }
}


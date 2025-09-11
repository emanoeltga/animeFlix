package com.correia.animeFlix.domain.dto;


import java.util.List;

public class CategoriaDTO {

    private String categoria;
    private List<CardDTO> card;

    // Getters e Setters

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<CardDTO> getCard() {
        return card;
    }

    public void setCard(List<CardDTO> card) {
        this.card = card;
    }
}


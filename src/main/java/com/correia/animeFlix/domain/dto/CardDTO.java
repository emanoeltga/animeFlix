package com.correia.animeFlix.domain.dto;

public class CardDTO {

    private String nome;
    private String image;
    private String link;

    public CardDTO(String nome, String image, String link) {
        this.nome = nome;
        this.image = image;
        this.link = link;
    }


// Getters e Setters

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}


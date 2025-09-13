package com.correia.animeFlix.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String image;
    private String link;

    public Card() {}

    private Card(Builder builder) {
        this.id = builder.id;
        this.nome = builder.nome;
        this.image = builder.image;
        this.link = builder.link;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }

    // Builder interno
    public static class Builder {
        private Long id;
        private String nome;
        private String image;
        private String link;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder image(String image) {
            this.image = image;
            return this;
        }

        public Builder link(String link) {
            this.link = link;
            return this;
        }

        public Card build() {
            return new Card(this);
        }
    }
}

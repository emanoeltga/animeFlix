package com.correia.animeFlix.domain.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Card> card;

    //Executa o codigo antes de inserir no banco de dados
    @PrePersist
    @PreUpdate
    public void formatNome() {
        if (nome != null) {
            nome = nome.toUpperCase();
        }
    }

    public Categoria() {}

    private Categoria(Builder builder) {
        this.id = builder.id;
        this.nome = builder.nome;
        this.card = builder.card;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<Card> getCard() { return card; }
    public void setCard(List<Card> card) { this.card = card; }

    // Builder interno
    public static class Builder {
        private Long id;
        private String nome;
        private List<Card> card;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder card(List<Card> card) {
            this.card = card;
            return this;
        }

        public Categoria build() {
            return new Categoria(this);
        }
    }
}

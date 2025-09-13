package com.correia.animeFlix.domain.dto;

import com.correia.animeFlix.domain.model.Card;

public class CardDTO {
    private String nome;
    private String image;
    private String link;

    public CardDTO() {

    }

    // Construtor privado -> usado só pelo Builder
    private CardDTO(Builder builder) {
        this.nome = builder.nome;
        this.image = builder.image;
        this.link = builder.link;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }

    // Builder interno
    public static class Builder {
        private String nome;
        private String image;
        private String link;

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

        public CardDTO build() {
            return new CardDTO(this);
        }
    }

    // Entidade -> DTO
    public static CardDTO fromEntity(Card card) {
        return new CardDTO.Builder()
                .nome(card.getNome())
                .image(card.getImage())
                .link(card.getLink())
                .build();
    }

    // DTO -> Entidade
    public Card toEntity() {
        return new Card.Builder()
                .nome(this.nome)
                .image(this.image)
                .link(this.link)
                .build();
    }
}

package com.correia.animeFlix.domain.dto;

import com.correia.animeFlix.domain.model.Categoria;

import java.util.List;
import java.util.stream.Collectors;

public class CategoriaDTO {
    private String nome;
    private List<CardDTO> card;
    public CategoriaDTO() {
    }
    private CategoriaDTO(Builder builder) {
        this.nome = builder.nome;
        this.card = builder.card;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<CardDTO> getCard() { return card; }
    public void setCard(List<CardDTO> card) { this.card = card; }

    // Builder interno
    public static class Builder {
        private String nome;
        private List<CardDTO> card;

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder card(List<CardDTO> card) {
            this.card = card;
            return this;
        }

        public CategoriaDTO build() {
            return new CategoriaDTO(this);
        }
    }

    // Entidade -> DTO
    public static CategoriaDTO fromEntity(Categoria categoria) {
        return new CategoriaDTO.Builder()
                .nome(categoria.getNome())
                .card(categoria.getCard()
                        .stream()
                        .map(CardDTO::fromEntity)
                        .collect(Collectors.toList()))
                .build();
    }

    // DTO -> Entidade
    public Categoria toEntity() {
        return new Categoria.Builder()
                .nome(this.nome)
                .card(this.card.stream()
                        .map(CardDTO::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}

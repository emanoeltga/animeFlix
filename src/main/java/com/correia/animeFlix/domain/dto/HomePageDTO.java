package com.correia.animeFlix.domain.dto;

import com.correia.animeFlix.domain.model.Categoria;

import java.util.List;

public class HomePageDTO {
    private String pagina;
    private List<CardDTO> sugeridos;
    private List<CategoriaDTO> categorias;
    public HomePageDTO(){

    }

    public String getPagina() {
        return pagina;
    }

    public List<CardDTO> getSugeridos() {
        return sugeridos;
    }

    public List<CategoriaDTO> getCategorias() {
        return categorias;
    }

    public HomePageDTO(Builder builder) {
        this.pagina = builder.pagina;
        this.sugeridos = builder.sugeridos;
        this.categorias = builder.categorias;
    }

    public static class Builder{
        private String pagina;
        private List<CardDTO> sugeridos;
        private List<CategoriaDTO> categorias;

        public Builder pagina(String pagina){
            this.pagina=pagina;
            return this;
        }
        public Builder sugeridos(List<CardDTO> sugeridos){
            this.sugeridos=sugeridos;
            return this;
        }
        public Builder categorias(List<CategoriaDTO> categorias){
            this.categorias=categorias;
            return this;
        }
        public HomePageDTO build(){
            return new HomePageDTO(this);
        }
    }
}

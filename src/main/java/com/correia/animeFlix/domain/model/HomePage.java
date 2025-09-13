package com.correia.animeFlix.domain.model;

import java.util.List;

public class HomePage {
    private String pagina;
    private List<Categoria> sugeridos;
    private List<Categoria> categorias;

    public HomePage() {}

    public HomePage(String pagina, List<Categoria> sugeridos, List<Categoria> categorias) {
        this.pagina = pagina;
        this.sugeridos = sugeridos;
        this.categorias = categorias;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public List<Categoria> getSugeridos() {
        return sugeridos;
    }

    public void setSugeridos(List<Categoria> sugeridos) {
        this.sugeridos = sugeridos;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}


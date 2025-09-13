package com.correia.animeFlix.service;

import com.correia.animeFlix.domain.dto.HomePageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomePageService {

    @Autowired
    private CategoriaService categoriaService;
    public HomePageDTO getIntialHome(){
        HomePageDTO page = new HomePageDTO.Builder()
                .pagina("HOME")
                .categorias(categoriaService.getCategoriasOrdenadas())
                .sugeridos(categoriaService.getCategoriasOrdenadas())
                .build();

        return new HomePageDTO();
    }
}

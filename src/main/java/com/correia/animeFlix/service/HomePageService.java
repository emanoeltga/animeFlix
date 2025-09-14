package com.correia.animeFlix.service;

import com.correia.animeFlix.domain.dto.HomePageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomePageService {

    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private CardService cardService;
    public HomePageDTO getIntialHome(String findPage){
        HomePageDTO page = new HomePageDTO.Builder()
                .pagina(findPage)
                .categorias(categoriaService.getCategoriasOrdenadas())
                .sugeridos(cardService.findSugeridos())
                .build();

        return page;
    }
}

package com.correia.animeFlix.controller;

import com.correia.animeFlix.domain.dto.HomePageDTO;
import com.correia.animeFlix.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PaginaController {


    public HomePageDTO getPage(@PathVariable String page) {

        return null;
    }
}

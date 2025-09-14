package com.correia.animeFlix.service;

import com.correia.animeFlix.domain.dto.CardDTO;
import com.correia.animeFlix.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public List<CardDTO> findSugeridos() {
        long total = cardRepository.count();
        if (total == 0) return List.of();

        int page = new Random().nextInt((int) Math.max(1, total / 4));
        return cardRepository.findAll(PageRequest.of(page, 4))
                .stream()
                .map(CardDTO::fromEntity)
                .toList();
    }

}

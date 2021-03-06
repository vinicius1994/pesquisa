package com.devsuperior.pesquisa.controllers;

import com.devsuperior.pesquisa.dto.GameDTO;
import com.devsuperior.pesquisa.dto.RecordDTO;
import com.devsuperior.pesquisa.entities.Game;
import com.devsuperior.pesquisa.repositories.GameRepository;
import com.devsuperior.pesquisa.services.GameService;
import com.devsuperior.pesquisa.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private RecordService recordService;

    @GetMapping
    public ResponseEntity<List<GameDTO>> findAll() {
        List<GameDTO> list = gameService.findAll();
        return ResponseEntity.ok().body(list);
    }
}


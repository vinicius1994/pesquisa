package com.devsuperior.pesquisa.controllers;

import com.devsuperior.pesquisa.dto.GameDTO;
import com.devsuperior.pesquisa.dto.RecordDTO;
import com.devsuperior.pesquisa.dto.RecordInsertDTO;
import com.devsuperior.pesquisa.services.GameService;
import com.devsuperior.pesquisa.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(value = "/records")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @PostMapping
    public ResponseEntity<RecordDTO> insert(@RequestBody RecordInsertDTO dto) {

        RecordDTO newDTO = recordService.insert(dto);
        return ResponseEntity.ok().body(newDTO);
    }

    @GetMapping
    public ResponseEntity<Page<RecordDTO>> findAll(
            @RequestParam(value = "min", defaultValue = "") String min,
            @RequestParam(value = "max", defaultValue = "") String max,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "0") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
            @RequestParam(value = "direction", defaultValue = "DESC") String direction) {

        Instant minDate = ("".equals(min)) ? null : Instant.parse(min);
        Instant maxDate = ("".equals(min)) ? null : Instant.parse(max);

        if (linesPerPage == 0) {
            linesPerPage = Integer.MAX_VALUE;
        }

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction),orderBy);

        Page<RecordDTO> list = recordService.findByMoments(minDate, maxDate, pageRequest);
        return ResponseEntity.ok().body(list);


    }
}

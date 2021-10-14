package com.example.demo.controllers;

import com.example.demo.models.dto.GoodDTO;
import com.example.demo.services.impl.GoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

@RestController
@Validated
@RequestMapping("/goods")
public class GoodController {

    private final GoodServiceImpl goodService;

    @Autowired
    public GoodController(GoodServiceImpl goodService) {
        this.goodService = goodService;
    }

    @GetMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public List<GoodDTO> getAllGoods() {
        return goodService.getAllGoods();
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public GoodDTO getById(@Positive @PathVariable Long id) {
        return goodService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@Positive @PathVariable Long id) {
        goodService.delete(id);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public GoodDTO create(@NotNull GoodDTO goodDTO) {
        return goodService.create(goodDTO);
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public GoodDTO update(@NotNull GoodDTO goodDTO) {
        return goodService.update(goodDTO);
    }


}

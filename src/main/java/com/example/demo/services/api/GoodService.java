package com.example.demo.services.api;

import com.example.demo.models.dto.GoodDTO;

import java.util.List;

public interface GoodService {

    GoodDTO create(GoodDTO goodDTO);

    GoodDTO update(GoodDTO goodDTO);

    void delete(Long id);

    List<GoodDTO> getAllGoods();

    GoodDTO getById(Long id);
}

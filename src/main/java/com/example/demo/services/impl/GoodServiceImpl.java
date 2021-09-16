package com.example.demo.services.impl;

import com.example.demo.mappers.GoodMapper;
import com.example.demo.models.dao.GoodEntity;
import com.example.demo.models.dto.GoodDTO;
import com.example.demo.repositories.GoodRepository;
import com.example.demo.services.api.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GoodServiceImpl implements GoodService {

    private final GoodRepository repository;
    private final GoodMapper mapper;

    @Autowired
    public GoodServiceImpl(GoodRepository repository, GoodMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public GoodDTO create(GoodDTO goodDTO) {
        if(goodDTO.getId() != null) {
            throw new IllegalArgumentException("Товар с таким Id уже существует");
        }
        return mapper.goodToGoodDto(mapper.goodEntityToGood(
                repository.save(mapper.goodToGoodEntity(mapper.goodDtoToGood(goodDTO)))));
    }

    @Override
    public GoodDTO update(GoodDTO goodDTO) {
        checkGoodExistence(goodDTO.getId());
        return mapper.goodToGoodDto(mapper.goodEntityToGood(
                repository.save(mapper.goodToGoodEntity(mapper.goodDtoToGood(goodDTO)))));
    }

    @Override
    public void delete(Long id) {
        checkGoodExistence(id);
        repository.deleteById(id);
    }

    @Override
    public List<GoodDTO> getAllGoods() {
        List<GoodDTO> goodDTOS = new ArrayList<>();
        List<GoodEntity> goodEntities = repository.findAll();

        for (GoodEntity entity : goodEntities) {
            goodDTOS.add(mapper.goodToGoodDto(mapper.goodEntityToGood(entity)));
        }
        return goodDTOS;
    }

    @Override
    public GoodDTO getById(Long id) {
        return mapper.goodToGoodDto(mapper.goodEntityToGood(repository.getById(id)));
    }

    private void checkGoodExistence(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException(String.format("There is no user with id = %d!", id));
        }
    }
}

package com.example.demo.mappers;

import com.example.demo.models.dao.GoodEntity;
import com.example.demo.models.domain.Good;
import com.example.demo.models.dto.GoodDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
public interface GoodMapper {


    Good goodDtoToGood(GoodDTO goodDTO);

    GoodDTO goodToGoodDto(Good good);

    Good goodEntityToGood(GoodEntity goodEntity);

    GoodEntity goodToGoodEntity(Good good);

}

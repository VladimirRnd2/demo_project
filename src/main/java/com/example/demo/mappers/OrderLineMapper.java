package com.example.demo.mappers;

import com.example.demo.models.dao.OrderLineEntity;
import com.example.demo.models.domain.OrderLine;
import com.example.demo.models.dto.OrderLineDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
public interface OrderLineMapper {

    OrderLine orderLineDtoToOrderLine(OrderLineDTO orderLineDTO);

    OrderLineDTO orderLineToOrderLineDto(OrderLine orderLine);

    OrderLine orderLineEntityToOrderLine(OrderLineEntity orderLineEntity);

    OrderLineEntity orderLineToOrderLineEntity(OrderLine orderLine);
}

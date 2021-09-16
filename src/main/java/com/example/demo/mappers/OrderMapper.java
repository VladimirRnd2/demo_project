package com.example.demo.mappers;

import com.example.demo.models.dao.OrderEntity;
import com.example.demo.models.domain.Order;

import com.example.demo.models.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order orderDtoToOrder(OrderDTO orderDTO);

    OrderDTO orderToOrderDto(Order order);

    Order orderEntityToOrder (OrderEntity orderEntity);

    OrderEntity orderToOrderEntity(Order order);

}

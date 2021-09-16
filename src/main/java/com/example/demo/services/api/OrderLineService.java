package com.example.demo.services.api;

import com.example.demo.models.dto.OrderLineDTO;

import java.util.List;

public interface OrderLineService {

    OrderLineDTO create(OrderLineDTO orderLineDTO);

    OrderLineDTO update(OrderLineDTO orderLineDTO);

    void delete(Long id);

    List<OrderLineDTO> getAllOrderLines();

    OrderLineDTO getById(Long id);
}

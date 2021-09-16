package com.example.demo.services.api;


import com.example.demo.models.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    OrderDTO create(OrderDTO orderDTO);

    OrderDTO update(OrderDTO goodDTO);

    void delete(Long id);

    List<OrderDTO> getAllOrder();

    OrderDTO getById(Long id);
}

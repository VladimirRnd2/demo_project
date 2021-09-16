package com.example.demo.services.impl;


import com.example.demo.mappers.OrderMapper;
import com.example.demo.models.dao.OrderEntity;
import com.example.demo.models.dto.OrderDTO;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.services.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final OrderMapper mapper;

    @Autowired
    public OrderServiceImpl(OrderRepository repository, OrderMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        if(orderDTO.getId() != null){
            throw new IllegalArgumentException("Order is already exists!");
        }
        return mapper.orderToOrderDto(mapper.orderEntityToOrder(repository
                .save(mapper.orderToOrderEntity(mapper.orderDtoToOrder(orderDTO)))));
    }

    @Override
    public OrderDTO update(OrderDTO orderDTO) {
        checkGoodExistence(orderDTO.getId());
        return mapper.orderToOrderDto(mapper.orderEntityToOrder(repository
                .save(mapper.orderToOrderEntity(mapper.orderDtoToOrder(orderDTO)))));
    }

    @Override
    public void delete(Long id) {
        checkGoodExistence(id);
        repository.deleteById(id);
    }

    @Override
    public List<OrderDTO> getAllOrder() {
        List<OrderDTO> dtoList = new ArrayList<>();
        List<OrderEntity> entityList = repository.findAll();

        for (OrderEntity entity: entityList) {
            dtoList.add(mapper.orderToOrderDto(mapper.orderEntityToOrder(entity)));
        }
        return dtoList;
    }

    @Override
    public OrderDTO getById(Long id) {
        return mapper.orderToOrderDto(mapper.orderEntityToOrder(repository.getById(id)));
    }

    private void checkGoodExistence(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException(String.format("There is no user with id = %d!", id));
        }
    }
}

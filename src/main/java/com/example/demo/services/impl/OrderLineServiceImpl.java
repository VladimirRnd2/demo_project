package com.example.demo.services.impl;

import com.example.demo.mappers.OrderLineMapper;
import com.example.demo.models.dao.OrderLineEntity;
import com.example.demo.models.dto.OrderLineDTO;
import com.example.demo.repositories.OrderLineRepository;
import com.example.demo.services.api.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderLineServiceImpl implements OrderLineService {

    private final OrderLineRepository repository;
    private final OrderLineMapper mapper;

    @Autowired
    public OrderLineServiceImpl(OrderLineRepository repository, OrderLineMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public OrderLineDTO create(OrderLineDTO orderLineDTO) {
        if(orderLineDTO.getId() != null) {
            throw new IllegalArgumentException("Строка заказа уже существует");
        }
        return mapper.orderLineToOrderLineDto(mapper.orderLineEntityToOrderLine(repository.
                save(mapper.orderLineToOrderLineEntity(mapper.orderLineDtoToOrderLine(orderLineDTO)))));
    }

    @Override
    public OrderLineDTO update(OrderLineDTO orderLineDTO) {
        checkGoodExistence(orderLineDTO.getId());
        return mapper.orderLineToOrderLineDto(mapper.orderLineEntityToOrderLine(repository.
                save(mapper.orderLineToOrderLineEntity(mapper.orderLineDtoToOrderLine(orderLineDTO)))));
    }

    @Override
    public void delete(Long id) {
        checkGoodExistence(id);
        repository.deleteById(id);
    }

    @Override
    public List<OrderLineDTO> getAllOrderLines() {
        List<OrderLineDTO> orderLineDTOS = new ArrayList<>();
        List<OrderLineEntity> orderLineEntities =  repository.findAll();

        for (OrderLineEntity entity : orderLineEntities) {
            orderLineDTOS.add(mapper.orderLineToOrderLineDto(mapper.orderLineEntityToOrderLine(entity)));
        }
        return orderLineDTOS;
    }

    @Override
    public OrderLineDTO getById(Long id) {
        return mapper.orderLineToOrderLineDto(mapper.orderLineEntityToOrderLine(repository.getById(id)));
    }

    private void checkGoodExistence(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException(String.format("There is no user with id = %d!", id));
        }
    }
}

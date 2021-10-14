package com.example.demo.controllers;

import com.example.demo.models.domain.Order;
import com.example.demo.models.dto.OrderDTO;
import com.example.demo.services.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Validated
@RequestMapping("/orders")
public class OrderController {

    private final OrderServiceImpl orderService;

    @Autowired
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<OrderDTO> getAll() {
        return orderService.getAllOrder();
    }
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public OrderDTO create(@RequestBody OrderDTO orderDTO) {
        return orderService.create(orderDTO);
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public OrderDTO update(@RequestBody @NotNull OrderDTO orderDTO) {
        return orderService.update(orderDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@Positive @PathVariable Long id) {
        orderService.delete(id);
    }

    @GetMapping(path="/{id}", produces = APPLICATION_JSON_VALUE)
    public OrderDTO getById(@Positive @PathVariable Long id) {
        return orderService.getById(id);
    }



}

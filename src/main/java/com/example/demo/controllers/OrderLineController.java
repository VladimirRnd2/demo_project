package com.example.demo.controllers;

import com.example.demo.services.impl.OrderServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Validated
@RequestMapping()
public class OrderLineController {

    private final OrderServiceImpl orderService;

    public OrderLineController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }


}

package com.example.demo.controllers;

import com.example.demo.models.dto.OrderLineDTO;
import com.example.demo.services.impl.OrderLineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Validated
@RequestMapping("/order_lines")
public class OrderLineController {

    private final OrderLineServiceImpl orderLineService;

    @Autowired
    public OrderLineController(OrderLineServiceImpl orderLineService) {
        this.orderLineService = orderLineService;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<OrderLineDTO> getAllOrderLines() {
        return orderLineService.getAllOrderLines();
    }
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public OrderLineDTO create (@NotNull OrderLineDTO orderLineDTO) {
        return orderLineService.create(orderLineDTO);
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public OrderLineDTO update(@NotNull OrderLineDTO orderLineDTO) {
        return orderLineService.update(orderLineDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@Positive @PathVariable Long id) {
        orderLineService.delete(id);
    }

    @GetMapping(path="/{id}", produces = APPLICATION_JSON_VALUE)
    public OrderLineDTO getById(@Positive@PathVariable Long id) {
        return orderLineService.getById(id);
    }

}

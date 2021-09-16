package com.example.demo.models.dto;

import com.example.demo.models.domain.Good;
import com.example.demo.models.domain.Order;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class OrderLineDTO {

    @NotEmpty
    @Positive
    private Long id;

    @NotEmpty
    @Positive
    private Long count;

    @NotNull
    private Good good;

    @NotNull
    private Order order;

    public OrderLineDTO() {
    }

    public OrderLineDTO(Long count, Good good, Order order) {
        this.count = count;
        this.good = good;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

package com.example.demo.models.dto;

import com.example.demo.models.domain.OrderLine;

import javax.validation.constraints.*;

public class GoodDTO {

    @NotEmpty
    @Positive
    private Long id;

    @NotBlank
    @Size(min = 2, max = 32)
    private String name;

    @NotEmpty
    private Double price;

    @NotNull
    private OrderLine orderLine;

    public GoodDTO() {
    }

    public GoodDTO(String name, Double price, OrderLine orderLine) {
        this.name = name;
        this.price = price;
        this.orderLine = orderLine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public OrderLine getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(OrderLine orderLine) {
        this.orderLine = orderLine;
    }
}

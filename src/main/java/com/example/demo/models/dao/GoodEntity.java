package com.example.demo.models.dao;

import javax.persistence.*;

@Entity
@Table(name = "GOOD")
public class GoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Name",length = 64, nullable = false)
    private String name;

    @Column(name = "Price", nullable = false)
    private Double price;

    @OneToOne(mappedBy = "good", cascade = CascadeType.ALL, orphanRemoval = true)
    private OrderLineEntity orderLine;

    public GoodEntity() {
    }

    public Long getId() {
        return id;
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

    public OrderLineEntity getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(OrderLineEntity orderLine) {
        this.orderLine = orderLine;
    }
}

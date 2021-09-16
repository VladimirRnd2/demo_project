package com.example.demo.models.dao;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_LINE")
public class OrderLineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "Count")
    private Long count;

    @OneToOne
    @JoinColumn(name = "goods_id")
    private GoodEntity good;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;


    public OrderLineEntity() {
    }

    public Long getId() {
        return id;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public GoodEntity getGood() {
        return good;
    }

    public void setGood(GoodEntity good) {
        this.good = good;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity orders) {
        this.order = orders;
    }
}

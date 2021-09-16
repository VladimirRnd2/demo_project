package com.example.demo.models.dto;

import com.example.demo.models.domain.OrderLine;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;

public class OrderDTO {

    @NotEmpty
    @Positive
    private Long id;

    @NotBlank
    @Size(min = 2, max = 64)
    private String client;

    @PastOrPresent
    @NotNull
    private Date date;

    @NotBlank
    @Size(min = 5, max = 64)
    private String address;

    @NotNull
    private List<OrderLine> orderLines;

    public OrderDTO() {
    }

    public OrderDTO(String client, Date date, String address, List<OrderLine> orderLines) {
        this.client = client;
        this.date = date;
        this.address = address;
        this.orderLines = orderLines;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}

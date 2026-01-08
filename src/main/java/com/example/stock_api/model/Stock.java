package com.example.stock_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @Column(name = "product_id")
    private Long productId;

    private int stock;
    private int sells;
    private int ingress;

    // Required by JPA
    protected Stock() {}

    public Stock(Long productId, int stock) {
        this.productId = productId;
        this.stock = stock;
        this.sells = 0;
        this.ingress = 0;
    }

    public Long getProductId() {
        return productId;
    }

    public int getStock() {
        return stock;
    }

    public int getSells() {
        return sells;
    }

    public int getIngress() {
        return ingress;
    }
}

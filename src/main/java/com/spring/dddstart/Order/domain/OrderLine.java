package com.spring.dddstart.Order.domain;

public class OrderLine {
    private Product product;
    private Money price;
    private int quantity;
    private int amounts;

    public Money calculateAmounts() {
        return price.multiply(quantity);
    }
}
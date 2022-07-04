package br.com.refound.model;

import java.math.BigDecimal;

public class Product {

    public Product(Integer id, BigDecimal value) {
        this.id = id;
        this.value = value;
    }

    private final Integer id;
    private final BigDecimal value;

    public Integer getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }
}

package br.com.refound.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    public Order(Integer id,String date) {
        this.id = id;
        this.total = BigDecimal.valueOf(0);
        this.date = date;
        this.products = new ArrayList<>();
    }

    public void addToTotal(BigDecimal value){
        this.total = this.total.add(value);
    }

    private final Integer id;
    private BigDecimal total;
    private final String date;
    private List<Product> products;
    public Integer getId() {
        return id;
    }
    public BigDecimal getTotal() {
        return total;
    }

    public String getDate() {
        return date;
    }
    public List<Product> getProducts() {
        return products;
    }
}

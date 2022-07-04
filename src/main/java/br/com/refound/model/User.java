package br.com.refound.model;

import java.util.HashMap;
import java.util.Map;

public class User {

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.orders = new HashMap<>();
    }

    private final Integer id;
    private final String name;
    private Map<Integer, Order> orders;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }
}

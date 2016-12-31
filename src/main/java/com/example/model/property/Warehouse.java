package com.example.model.property;


import com.example.model.account.User;

import javax.persistence.Entity;

@Entity
public class Warehouse extends AbstractProperty {

    public Warehouse(User owner, Double price, Double size, int age) {
        super(owner, Type.WAREHOUSE, price, size, age);
    }

    protected Warehouse() {
    }
}

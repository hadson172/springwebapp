package com.example.model.property;

import com.example.model.account.User;

import javax.persistence.Entity;

@Entity
public class House extends AbstractProperty {

    private String housee;

    public House(User owner, Double price, Double size, int age) {
        super(owner, Type.HOUSE, price, size, age);
    }

    protected House() {

    }

    public String getHousee() {
        return housee;
    }
}

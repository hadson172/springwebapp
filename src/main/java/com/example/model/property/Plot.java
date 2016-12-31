package com.example.model.property;

import com.example.model.account.User;

import javax.persistence.Entity;

@Entity
public class Plot extends AbstractProperty {

    public Plot(User owner, Double price, Double size, int age) {
        super(owner, Type.PLOT, price, size, age);
    }

    protected Plot() {

    }
}

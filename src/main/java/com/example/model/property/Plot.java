package com.example.model.property;

import com.example.model.account.User;

import javax.persistence.Entity;
import java.time.Year;

@Entity
public class Plot extends AbstractProperty {

    public Plot(User owner, double price, double area, Year buildYear) {
        super(owner, Type.PLOT, price, area, buildYear);
    }

    protected Plot() {

    }
}

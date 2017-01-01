package com.example.model.property;


import com.example.model.account.User;

import javax.persistence.Entity;
import java.time.Year;

@Entity
public class Warehouse extends AbstractProperty {

    private int storageArea;

    public Warehouse(User owner, double price, double area, Year yearOfBuild) {
        super(owner, Type.WAREHOUSE, price, area, yearOfBuild);
    }

    protected Warehouse() {
    }

    public int getStorageArea() {
        return storageArea;
    }

    public void setStorageArea(int storageArea) {
        this.storageArea = storageArea;
    }
}

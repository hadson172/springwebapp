package com.example.model.property;

import com.example.model.account.User;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import java.time.Year;

@Entity
public class House extends AbstractProperty {

    @Enumerated
    private HouseType houseType;

    private int numberOfStorey;

    public House(User owner, double price, double area, Year buildYear) {
        super(owner, Type.HOUSE, price, area, buildYear);
    }

    protected House() {

    }

    public HouseType getHouseType() {
        return houseType;
    }

    public void setHouseType(HouseType houseType) {
        this.houseType = houseType;
    }

    public int getNumberOfStorey() {
        return numberOfStorey;
    }

    public void setNumberOfStorey(int numberOfStorey) {
        this.numberOfStorey = numberOfStorey;
    }

    public enum HouseType {
        BEDSIT,
        BUNGALOW,
        DETACHED_HOUSE,
        TERRACED_HOUSE,
        MANSION,
        SEMIDETACHED_HOUSE
    }
}

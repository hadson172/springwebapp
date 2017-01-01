package com.example.model.property;

import com.example.model.account.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.Year;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class AbstractProperty {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User owner;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    private double price;
    private double area;
    private Year buildYear;
    private LocalDateTime creationTime;

    public AbstractProperty() {

    }

    public AbstractProperty(User owner, Type type, double price, double area, Year buildYear) {
        this.owner = owner;
        this.type = type;
        this.price = price;
        this.area = area;
        this.buildYear = buildYear;
        creationTime = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    @JsonIgnore
    public User getOwner() {
        return owner;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Year getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(Year buildYear) {
        this.buildYear = buildYear;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public enum Type {
        HOUSE,
        PLOT,
        WAREHOUSE

    }
}



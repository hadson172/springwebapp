package com.example.model.property;

import com.example.model.account.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

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
    private double size;
    private int age;

    public AbstractProperty() {
    }

    public AbstractProperty(User owner, Type type, double price, Double size, int age) {
        this.owner = owner;
        this.type = type;
        this.price = price;
        this.size = size;
        this.age = age;
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

    public double getSize() {
        return size;
    }

    public int getAge() {
        return age;
    }

    public enum Type {
        HOUSE,
        PLOT,
        WAREHOUSE

    }
}



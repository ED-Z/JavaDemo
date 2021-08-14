package com.example.jtaDemo.dao.entity;

import javax.persistence.Id;

public class Seller {
    @Id
    private String id;

    private String name;

    private Integer healthPotion;

    private Integer gold;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealthPotion() {
        return healthPotion;
    }

    public void setHealthPotion(Integer healthPotion) {
        this.healthPotion = healthPotion;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }
}

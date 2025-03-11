package com.pd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity(name = "Pokemon_name")
public class Pokemon {

    @Id
    @Column(length = 191) // Reducing length to fit within index length limits
    private String name;

    @Column(nullable=false)
    private String type;

    @Column
    private int power;

    @Enumerated(EnumType.STRING)
    private Color color;


    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPower() {
        return this.power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString(){
        return this.getName() + " " + this.getType() + " " + this.getPower() + " " +this.getColor();
    }
}

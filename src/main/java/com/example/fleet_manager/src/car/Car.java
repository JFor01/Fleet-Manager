package com.example.fleet_manager.src.car;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Car {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String referenceName;
    @Column
    private String brand;
    @Column
    private boolean inUse;


    protected Car(){

    };

    public Car(String referenceName, String brand, boolean inUse){
        this.referenceName = referenceName;
        this.brand = brand;
        this.inUse = inUse;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setActive(){
        this.inUse = true;
    }

    public void setInActive(){
        this.inUse = false;
    }

    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isInUse() {
        return inUse;
    }

}

package com.example.fleet_manager.car;

import com.example.fleet_manager.driver.Driver;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.stereotype.Controller;

import javax.annotation.processing.Generated;

@Entity
public class Car {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String referenceName;
    @Column
    private String brand;


    protected Car(){

    };

    public Car(String referenceName, String brand){
        this.referenceName = referenceName;
        this.brand = brand;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}

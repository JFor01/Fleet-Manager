package com.example.fleet_manager.trip;

import com.example.fleet_manager.car.Car;
import com.example.fleet_manager.driver.Driver;
import jakarta.persistence.*;

@Entity
public class Trip {

    public enum Status {
        COMMENCING,
        ACTIVE,
        FINISHED
    }
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    private Status status;
    private String destination;
    private String origin;

    protected Trip(){

    };

    public Trip (Driver driver, Car car, Status status,
                 String destination, String origin
                 ){
        this.driver = driver;
        this.car = car;
        this.status = status;
        this.destination = destination;
        this.origin = origin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}

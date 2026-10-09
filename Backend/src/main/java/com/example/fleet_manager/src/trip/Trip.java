package com.example.fleet_manager.src.trip;

import com.example.fleet_manager.src.car.Car;
import com.example.fleet_manager.src.driver.Driver;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Entity
public class Trip {

    public enum Status {
        COMMENCING,
        ACTIVE,
        FINISHED
    }
    @Id
    @GeneratedValue
    private Long id;
    @CreationTimestamp
    @Column(updatable = false)
    private Date created_at;

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

    public Trip (Driver driver, Car car,
                 String destination, String origin
    ){
        this.driver = driver;
        this.car = car;
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

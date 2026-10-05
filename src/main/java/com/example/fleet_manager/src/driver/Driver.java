package com.example.fleet_manager.src.driver;

import jakarta.persistence.*;
import jdk.jfr.Name;

import java.io.Serializable;
@Entity(name = "drivers")
public class Driver implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private boolean active = false;

    protected Driver(){

    }

    public Driver (String name, int age){
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive(){
        return active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

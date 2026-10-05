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
    private boolean active;

    protected Driver(){

    }

    public Driver (String name, int age, boolean active){
        this.name = name;
        this.age = age;
        this.active = active;
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

    public void setActive(){
        this.active = true;
    }
    public void setInactive(){
        this.active = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

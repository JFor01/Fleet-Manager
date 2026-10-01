package com.example.fleet_manager.src.trip;


import com.example.fleet_manager.src.car.Car;
import com.example.fleet_manager.src.driver.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TripPlanner {


    protected TripPlanner(){};

    public Trip createTrip(Driver driver, Car car,
            String destination, String origin){

        return new Trip(driver,car, Trip.Status.COMMENCING,destination,origin);
    }


    public void startTrip(Trip trip){
        trip.setStatus(Trip.Status.ACTIVE);
    }

    public void endTrip(Trip trip){
        trip.setStatus(Trip.Status.FINISHED);
    }





}

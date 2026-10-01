package com.example.fleet_manager.src.trip;

import com.example.fleet_manager.src.car.Car;
import com.example.fleet_manager.src.car.CarService;
import com.example.fleet_manager.src.driver.Driver;
import com.example.fleet_manager.src.driver.DriverService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TripService {

    private TripRepository tripRepository;
    private TripPlanner tripPlanner;



    public TripService (TripRepository tripRepository, TripPlanner tripPlanner){
        this.tripRepository = tripRepository;
        this.tripPlanner = tripPlanner;
    }


    public void saveTrip(Driver driver, Car car
        , String destination, String origin
        ){
        tripRepository.save(tripPlanner.createTrip(driver,car,destination,origin));
    }

    public Trip getTripById(Long id){
      Optional<Trip> tripOptional = tripRepository.findById(id);
      if (tripOptional.isPresent() ) return tripOptional.get();
      else throw new NoTripException("No such a trip");
    }

    public void deleteTripById(Long id){
        tripRepository.deleteById(id);
    }

    public void updateTrip(Trip trip){
        tripRepository.save(trip);
    }

    @Transactional
    public void startTrip(Long id){
        Trip trip = getTripById(id);
        tripPlanner.startTrip(trip);
        updateTrip(trip);
    }

    public void endTrip(Long id){
        Trip trip = getTripById(id);
        tripPlanner.endTrip(trip);
        updateTrip(trip);
    }

}

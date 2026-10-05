package com.example.fleet_manager.src.trip;

import com.example.fleet_manager.src.car.Car;
import com.example.fleet_manager.src.car.CarService;
import com.example.fleet_manager.src.driver.Driver;
import com.example.fleet_manager.src.driver.DriverService;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    private TripRepository tripRepository;
    private TripPlanner tripPlanner;



    public TripService (TripRepository tripRepository, TripPlanner tripPlanner){
        this.tripRepository = tripRepository;
        this.tripPlanner = tripPlanner;
    }


    public TripController.TripResponse saveTrip(Driver driver, Car car
        , String destination, String origin
        ){
        Trip trip = tripRepository.save(tripPlanner.createTrip(driver,car,destination,origin));
        return new TripController.TripResponse(trip.getId(), driver, car,trip.getStatus(), destination,origin);
    }

    public Trip getTripById(Long id){
      Optional<Trip> tripOptional = tripRepository.findById(id);
      if (tripOptional.isPresent() ) return tripOptional.get();
      else throw new NoTripException("No such a trip");
    }

    public ArrayList<Trip> getAllTrips(){
        ArrayList<Trip> tripArrayList = new ArrayList<>();
        tripRepository.findAll().forEach((trip) -> {tripArrayList.add(trip);});
        return tripArrayList;
    }


    public ArrayList<Trip> getAllTripsFromNewest(){
        ArrayList<Trip> tripArrayList = new ArrayList<>();
        tripRepository.findNewestFirst().forEach((trip) -> {tripArrayList.add(trip);});
        return tripArrayList;
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

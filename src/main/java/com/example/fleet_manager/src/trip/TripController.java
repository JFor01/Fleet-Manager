package com.example.fleet_manager.src.trip;


import com.example.fleet_manager.src.car.Car;
import com.example.fleet_manager.src.car.CarService;
import com.example.fleet_manager.src.driver.Driver;
import com.example.fleet_manager.src.driver.DriverService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trip")
public class TripController {

    public record TripResponse(Long driverId,
                                Long carId,Trip.Status status,String destination,
                                String origin){};

    private TripService tripService;
    private DriverService driverService;
    private CarService carService;

    public TripController(TripService tripService, DriverService driverService, CarService carService){
        this.tripService = tripService;
        this.driverService  =driverService;
        this.carService = carService;
    }

    @PostMapping
    public void saveTrip(@RequestBody TripResponse tripResponse){
        tripService.saveTrip(
                driverService.getDriverById(tripResponse.driverId),
                carService.getCarById(tripResponse.carId),
                tripResponse.destination,
                tripResponse.origin);
    }
    @GetMapping("/{id}")
    public Trip getTripById(@PathVariable Long id){
        return tripService.getTripById(id);
    }

    @DeleteMapping("{id}")
    public void deleteTripById(@PathVariable Long id){
        tripService.deleteTripById(id);
    }

    @PostMapping("/start/{id}")
    public void startTrip (@PathVariable Long id){
        tripService.startTrip(id);
    }
    @PostMapping("/end/{id}")
    public void endTrip (@PathVariable Long id){
        tripService.endTrip(id);
    }


}

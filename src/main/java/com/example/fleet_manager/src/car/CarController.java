package com.example.fleet_manager.src.car;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/car")
public class CarController {

    private CarService carService;
    public record CarResponse(String referenceName, String brand){};

    public CarController (CarService carService){
        this.carService = carService;
    }

    @PostMapping
    public void saveCar(@RequestBody CarResponse carResponse){
        carService.saveCar(carResponse.referenceName(),carResponse.brand());
    }
    @GetMapping("/{id}")
    public Car getCarById (@PathVariable Long id) {
        return carService.getCarById(id);
    }
    @GetMapping
    public ArrayList<Car> getCars (){
        return carService.getAllCars();
    }
    @DeleteMapping("/{id}")
    public void deleteCarById (@PathVariable Long id){
        carService.deleteCar(id);
    }
}

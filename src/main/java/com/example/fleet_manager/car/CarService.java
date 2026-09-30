package com.example.fleet_manager.car;


import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {
    private CarRepository carRepository;


    public CarService (CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public void saveCar(String referenceName, String brand){
        carRepository.save(new Car (referenceName,brand));
    }

    public Car getCarById(Long id){
        Optional<Car> optionCar =  carRepository.findById(id);
        if (optionCar.isPresent()) return optionCar.get();
        else throw new NoCarException("There is no car with id" + id);
    }

    public void deleteCar(Long id){
        carRepository.deleteById(id);
    }

}

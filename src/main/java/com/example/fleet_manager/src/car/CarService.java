package com.example.fleet_manager.src.car;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private CarRepository carRepository;


    public CarService (CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public void saveCar(String referenceName, String brand){
        carRepository.save(new Car (referenceName,brand, false));
    }

    public Car getCarById(Long id){
        Optional<Car> optionCar =  carRepository.findById(id);
        if (optionCar.isPresent()) return optionCar.get();
        else throw new NoCarException("There is no car with id" + id);
    }

    public ArrayList<Car> getAllCars (){
        ArrayList<Car> cars = new ArrayList<>();
        carRepository.findAll().forEach(car -> {cars.add(car);});
        return cars;
    }

    public void deleteCar(Long id){
        carRepository.deleteById(id);
    }
    public void setActive(Long id){
        Car car = getCarById(id);
        car.setActive();
        carRepository.save(car);
    }
    public void setInactive(Long id){
        Car car = getCarById(id);
        car.setInActive();
        carRepository.save(car);
    }

}

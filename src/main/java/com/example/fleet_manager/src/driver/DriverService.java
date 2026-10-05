package com.example.fleet_manager.src.driver;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DriverService {
    private DriverRepository driverRepository;

    public DriverService (DriverRepository driverRepository){
        this.driverRepository = driverRepository;
    }

    public void saveDriver (String name, int age){
        driverRepository.save(new Driver(name,age,false));
    }


    public Driver getDriverById (long id){
        Optional<Driver> driverOptional = driverRepository.findById(id);
        if (driverOptional.isPresent()) return driverOptional.get();
        else throw new NoDriverException("The requested driver wasn't found");
    }

    public ArrayList<Driver> getAllDrivers(){
        ArrayList<Driver> drivers = new ArrayList<>();
        driverRepository.findAll().forEach(driver -> {drivers.add(driver);});
        return drivers;
    }

   public void deleteDriver (Long id){
        driverRepository.deleteById(id);
   }

    public void setActive(Long id){
       Driver driver = getDriverById(id);
       driver.setActive();
       driverRepository.save(driver);

    }

    public void setInactive(Long id){
        Driver driver = getDriverById(id);
        driver.setInactive();
        driverRepository.save(driver);
    }


}

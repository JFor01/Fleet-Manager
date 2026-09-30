package com.example.fleet_manager.driver;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverService {
    private DriverRepository driverRepository;

    public DriverService (DriverRepository driverRepository){
        this.driverRepository = driverRepository;
    }

    public void saveDriver (String name, int age){
        driverRepository.save(new Driver(name,age));
    }

    public Driver getDriverById (long id){
        Optional<Driver> driverOptional = driverRepository.findById(id);
        if (driverOptional.isPresent()) return driverOptional.get();
        else throw new NoDriverException("The requested driver wasn't found");
    }

   public void deleteDriver (Long id){
        driverRepository.deleteById(id);
   }



}

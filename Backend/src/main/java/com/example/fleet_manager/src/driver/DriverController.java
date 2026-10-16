package com.example.fleet_manager.src.driver;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/driver")
public class DriverController {

    public record DriverRequest(String name, int age){}

    private DriverService driverService;

    public DriverController (DriverService driverService){
        this.driverService = driverService;
    }

    @PostMapping()
    public Driver saveDriver (@RequestBody DriverRequest driverRequest)
        {
           return driverService.saveDriver(driverRequest.name(),driverRequest.age());
    }
    @DeleteMapping("/{id}")
    public String deleteDriver (@PathVariable Long id){
        driverService.deleteDriver(id);
        return "Deleted driver " + id;
    }
    @GetMapping("/{id}")
    public Driver getDriver (@PathVariable Long id){
        return driverService.getDriverById(id);
    }
    @GetMapping
    public ArrayList<Driver> getAllDrivers(){
        return driverService.getAllDrivers();
    }



}

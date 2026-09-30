package com.example.fleet_manager.driver;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/driver")
public class DriverController {

    public record DriverRequest(String name, int age){}

    private DriverService driverService;

    public DriverController (DriverService driverService){
        this.driverService = driverService;
    }

    @PostMapping()
    public String saveDriver (@RequestBody DriverRequest driverRequest)
        {
            driverService.saveDriver(driverRequest.name(),driverRequest.age());
            return "Saved driver " + driverRequest.name;
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




}

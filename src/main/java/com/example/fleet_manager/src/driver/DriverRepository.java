package com.example.fleet_manager.src.driver;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends CrudRepository <Driver, Long> {

}

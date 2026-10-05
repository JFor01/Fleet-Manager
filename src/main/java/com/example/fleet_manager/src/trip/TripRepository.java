package com.example.fleet_manager.src.trip;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip,Long> {
    @Query("SELECT t from Trip t ORDER BY t.createdAt desc ")
    List<Trip> findNewestFirst();
}

package com.example.exercicio2.repository;

import com.example.exercicio2.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

    Car findByCarId(long carId);
    List<Car> findAll();

}

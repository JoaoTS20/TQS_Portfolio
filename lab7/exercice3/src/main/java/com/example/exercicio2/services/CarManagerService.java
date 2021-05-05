package com.example.exercicio2.services;

import com.example.exercicio2.entities.Car;
import com.example.exercicio2.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarManagerService {

    @Autowired
    private CarRepository carRepository;

    public CarManagerService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car save(Car car){
        return carRepository.save(car);
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public Car getCarDetails(long id) {
        return  carRepository.findByCarId( id);
    }

}

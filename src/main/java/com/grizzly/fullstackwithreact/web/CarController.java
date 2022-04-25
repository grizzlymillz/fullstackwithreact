package com.grizzly.fullstackwithreact.web;

import com.grizzly.fullstackwithreact.domain.Car;
import com.grizzly.fullstackwithreact.domain.CarRepository;
import com.grizzly.fullstackwithreact.domain.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    @Autowired
    private CarRepository repository;
    @RequestMapping("/cars")
    public Iterable<Car> getCars(){
        return repository.findAll();
    }
}

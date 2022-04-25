package com.grizzly.fullstackwithreact;

import com.grizzly.fullstackwithreact.domain.Car;
import com.grizzly.fullstackwithreact.domain.CarRepository;
import com.grizzly.fullstackwithreact.domain.Owner;
import com.grizzly.fullstackwithreact.domain.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    @Autowired
    private CarRepository repository;

    @Autowired
    private OwnerRepository ownerRepository;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info("http://localhost:8080/h2-console");
    }
    @Bean
    CommandLineRunner runner(){
        return args -> {
            Owner owner1 = new Owner("John", "Johnson");
            Owner owner2 = new Owner("Mary", "Robinson");
            ownerRepository.save(owner1);
            ownerRepository.save(owner2);

            Car car = new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1);
            repository.save(car);
            car = new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2);
            repository.save(car);
            car = new Car("Toyota", "Prius", "Silver", "KK0-0212", 2018, 39000, owner2);
            repository.save(car);
        };
    }
}
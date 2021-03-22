package hu.unideb.inf.java.jpa.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hu.unideb.inf.java.jpa.example.domain.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
    
}

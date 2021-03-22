package hu.unideb.inf.java.jpa.example.init;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.unideb.inf.java.jpa.example.domain.Car;
import hu.unideb.inf.java.jpa.example.domain.Person;
import hu.unideb.inf.java.jpa.example.repository.PersonRepository;

@Service
public class DataBaseInitializer {
    private PersonRepository personRepo;

    @Autowired
    public DataBaseInitializer(PersonRepository personRepo) {
        this.personRepo = personRepo;
    }
    
    public void init() {
        Person person = new Person();
        person.setFullName("Katona Zsombor");
        personRepo.save(person);
        Car car = new Car();
        car.setCarDescription("Fekete Trabant Zöld csíkokkal");
        car.setPerson(person);
        person.setCars(List.of(car));
        personRepo.save(person);
    }
}

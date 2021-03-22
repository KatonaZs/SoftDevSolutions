package hu.unideb.inf.java.jpa.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hu.unideb.inf.java.jpa.example.domain.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    Person findByFullName(String fullName);
}

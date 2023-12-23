package com.devsu.gateway;

import com.devsu.app.model.persistence.Person;

import java.util.List;
import java.util.UUID;

public interface PersonGateway {
    Person insert(Person person);
    Person update(Person person);
    boolean existById(UUID id);
    Iterable<Person> findAll();
    Person findById(UUID id);
    void delete(UUID id);
}

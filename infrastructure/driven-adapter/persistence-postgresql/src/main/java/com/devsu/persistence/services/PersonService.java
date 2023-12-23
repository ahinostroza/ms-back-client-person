package com.devsu.persistence.services;

import com.devsu.app.model.persistence.Person;
import com.devsu.gateway.PersonGateway;
import com.devsu.persistence.entities.PersonEntity;
import com.devsu.persistence.mapper.PersonMapper;
import com.devsu.persistence.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class PersonService implements PersonGateway {

    private final PersonRepository personRepository;
    private final PersonMapper mapper;

    @Override
    public Person insert(Person person) {
        return mapper.toModel(personRepository.save(mapper.toEntity(person)));
    }

    @Override
    public Person update(Person person) { return mapper.toModel(personRepository.save(mapper.toEntity(person))); }

    @Override
    public boolean existById(UUID id) { return personRepository.existsById(id); }

    @Override
    public Iterable<Person> findAll() {
        return mapper.map(personRepository.findAll());
    }

    @Override
    public Person findById(UUID id) { return mapper.toModel(personRepository.findById(id).get()); }

    @Override
    public void delete(UUID id) {
        personRepository.deleteById(id);
    }
}

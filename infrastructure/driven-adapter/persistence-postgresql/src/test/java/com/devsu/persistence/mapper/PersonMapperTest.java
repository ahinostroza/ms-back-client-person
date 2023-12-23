package com.devsu.persistence.mapper;

import com.devsu.app.model.persistence.Person;
import com.devsu.persistence.entities.PersonEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

class PersonMapperTest {

    @InjectMocks
    private PersonMapper personMapper = new PersonMapperImpl();
    private PersonEntity personEntity;
    private Person person;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        UUID personId = UUID.randomUUID();
        personEntity = new PersonEntity();
        personEntity.setPersonId(personId);
        personEntity.setName("Angel Jose");
        personEntity.setGender("Masculino");
        personEntity.setAge(27);
        personEntity.setDocument("72032902");
        personEntity.setAddress("Urb. San Pedro F-32");
        personEntity.setPhone("932750359");

        person = Person.builder()
                .personId(personId)
                .name("Angel Jose")
                .gender("Masculino")
                .age(27)
                .document("72032902")
                .address("Urb. San Pedro F-32")
                .phone("932750359").build();
    }

    @Test
    void toModel() {
        Person personMapped = personMapper.toModel(personEntity);
        Assertions.assertNotNull(personMapped);
        Assertions.assertEquals(person.getPersonId(),personMapped.getPersonId());
        Assertions.assertEquals(person.getName(),personMapped.getName());
        Assertions.assertEquals(person.getGender(),personMapped.getGender());
        Assertions.assertEquals(person.getAge(),personMapped.getAge());
        Assertions.assertEquals(person.getDocument(),personMapped.getDocument());
        Assertions.assertEquals(person.getAddress(),personMapped.getAddress());
        Assertions.assertEquals(person.getPhone(),personMapped.getPhone());
    }

    @Test
    void toEntity() {
        PersonEntity personMapped = personMapper.toEntity(person);
        Assertions.assertNotNull(personMapped);
        Assertions.assertEquals(personEntity.getPersonId(),personMapped.getPersonId());
        Assertions.assertEquals(personEntity.getName(),personMapped.getName());
        Assertions.assertEquals(personEntity.getGender(),personMapped.getGender());
        Assertions.assertEquals(personEntity.getAge(),personMapped.getAge());
        Assertions.assertEquals(personEntity.getDocument(),personMapped.getDocument());
        Assertions.assertEquals(personEntity.getAddress(),personMapped.getAddress());
        Assertions.assertEquals(personEntity.getPhone(),personMapped.getPhone());
    }
}

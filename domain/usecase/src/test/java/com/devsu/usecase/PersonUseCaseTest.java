package com.devsu.usecase;

import com.devsu.app.model.persistence.Person;
import com.devsu.gateway.PersonGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PersonUseCaseTest {
    @Mock
    private PersonGateway personGateway;

    @InjectMocks
    private PersonUseCase personUseCase;

    private Person person;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        person = Person.builder()
                .personId("ca15abb5-0fa5-495d-8280-042c024871ad")
                .name("Angel Jose")
                .gender("Masculino")
                .age(27)
                .document("72032902")
                .address("Urb. San Pedro F-32")
                .phone("932750359");
    }

    @Test
    void insertPerson() {
        when(personGateway.insert(any()))
                .thenReturn(person);
        Person result = personUseCase.insertPerson(person);
        Assertions.
    }
}

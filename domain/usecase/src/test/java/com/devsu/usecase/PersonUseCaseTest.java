package com.devsu.usecase;

import com.devsu.app.model.config.DevsuException;
import com.devsu.app.model.persistence.Person;
import com.devsu.gateway.PersonGateway;
import com.devsu.helper.MessageHelper;
import com.devsu.helper.constant.ExceptionConstant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class PersonUseCaseTest {
    @Mock
    private PersonGateway personGateway;
    @Mock
    private MessageHelper messageHelper;

    @InjectMocks
    private PersonUseCase personUseCase;

    private Person person;
    private List<Person> personIterable = new ArrayList<>();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        person = Person.builder()
                .personId(UUID.randomUUID())
                .name("Angel Jose")
                .gender("Masculino")
                .age(27)
                .document("72032902")
                .address("Urb. San Pedro F-32")
                .phone("932750359").build();

        personIterable.add(person);
    }

    @Test
    void insertPerson() {
        when(personGateway.insert(any()))
                .thenReturn(person);
        Person result = personUseCase.insertPerson(person);
        Assertions.assertEquals(Person.class, result.getClass());
    }

    @Test
    void listPersons() {
        when(personGateway.findAll())
                .thenReturn(personIterable);
        Iterable<Person> personList = personUseCase.listPersons();
        Assertions.assertEquals(StreamSupport.stream(personList.spliterator(), false).count(), personIterable.size());
    }

    @Test
    void findByPersonIdException() throws  Exception {
        when(personGateway.existById(any()))
                .thenReturn(false);
        Assertions.assertThrows(DevsuException.class, () -> personUseCase.findByPersonId(any()));
    }

    @Test
    void findByPersonId() {
        when(personGateway.existById(any()))
                .thenReturn(true);
        when(personGateway.findById(any()))
                .thenReturn(person);
        Person result = personUseCase.findByPersonId(UUID.randomUUID());
        Assertions.assertEquals(Person.class, result.getClass());
    }

    @Test
    void deletePersonException() throws Exception {
        when(personGateway.existById(any()))
                .thenReturn(false);
        Assertions.assertThrows(DevsuException.class, () -> personUseCase.deletePerson(person));
    }

    @Test
    void deletePerson() throws Exception {
        when(personGateway.existById(any()))
                .thenReturn(true);
        Assertions.assertDoesNotThrow(() -> personUseCase.deletePerson(person));
    }
}

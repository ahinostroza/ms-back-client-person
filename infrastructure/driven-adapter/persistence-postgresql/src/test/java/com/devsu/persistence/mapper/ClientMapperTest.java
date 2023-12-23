package com.devsu.persistence.mapper;

import com.devsu.app.model.persistence.Client;
import com.devsu.app.model.persistence.Person;
import com.devsu.persistence.entities.ClientEntity;
import com.devsu.persistence.entities.PersonEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class ClientMapperTest {

    @InjectMocks
    private ClientMapper clientMapper = new ClientMapperImpl();
    private PersonEntity personEntity;
    private Person person;
    private Client client;
    private ClientEntity clientEntity;
    private List<ClientEntity> clientIterable = new ArrayList<>();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        personEntity = new PersonEntity();
        personEntity.setPersonId(UUID.randomUUID());
        personEntity.setName("Angel Jose");
        personEntity.setGender("Masculino");
        personEntity.setAge(27);
        personEntity.setDocument("72032902");
        personEntity.setAddress("Urb. San Pedro F-32");
        personEntity.setPhone("932750359");

        person = Person.builder()
                .personId(UUID.randomUUID())
                .name("Angel Jose")
                .gender("Masculino")
                .age(27)
                .document("72032902")
                .address("Urb. San Pedro F-32")
                .phone("932750359").build();

        UUID clientId = UUID.randomUUID();
        client = Client.builder()
                .clientId(clientId)
                .password("123456")
                .status(true)
                .person(person).build();

        clientEntity = new ClientEntity();
        clientEntity.setClientId(clientId);
        clientEntity.setPassword("123456");
        clientEntity.setStatus(true);
        clientEntity.setPerson(personEntity);

        clientIterable.add(clientEntity);
    }

    @Test
    void toModel() {
        Client clientMapped = clientMapper.toModel(clientEntity);
        Assertions.assertNotNull(clientMapped);
        Assertions.assertEquals(client.getClientId(),clientMapped.getClientId());
        Assertions.assertEquals(client.getPassword(),clientMapped.getPassword());
        Assertions.assertEquals(client.getStatus(),clientMapped.getStatus());
    }

    @Test
    void toEntity() {
        ClientEntity clientMapped = clientMapper.toEntity(client);
        Assertions.assertNotNull(clientMapped);
        Assertions.assertEquals(clientEntity.getClientId(),clientMapped.getClientId());
        Assertions.assertEquals(clientEntity.getPassword(),clientMapped.getPassword());
        Assertions.assertEquals(clientEntity.getStatus(),clientMapped.getStatus());
    }

    @Test
    void map() {
        Iterable<Client> clientMapped = clientMapper.map(clientIterable);
        Client firstClient = clientMapped.iterator().next();
        Assertions.assertNotNull(clientMapped);
        Assertions.assertEquals(client.getClientId(),firstClient.getClientId());
        Assertions.assertEquals(client.getPassword(),firstClient.getPassword());
        Assertions.assertEquals(client.getStatus(),firstClient.getStatus());
    }
}

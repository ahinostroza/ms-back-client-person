package com.devsu.gateway;

import com.devsu.app.model.persistence.Client;

import java.util.UUID;

public interface ClientGateway {
    Client insert(Client client);
    Client update(Client client);
    boolean existById(UUID id);
    Iterable<Client> findAll();
    Client findById(UUID id);
    void delete(UUID id);
}

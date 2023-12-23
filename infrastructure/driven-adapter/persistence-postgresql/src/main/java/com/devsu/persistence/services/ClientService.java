package com.devsu.persistence.services;

import com.devsu.app.model.persistence.Client;
import com.devsu.gateway.ClientGateway;
import com.devsu.persistence.mapper.ClientMapper;
import com.devsu.persistence.repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class ClientService implements ClientGateway {

    private final ClientRepository clientRepository;
    private final ClientMapper mapper;

    @Override
    public Client insert(Client client) {
        return null;
    }

    @Override
    public Client update(Client client) {
        return null;
    }

    @Override
    public boolean existById(UUID id) {
        return false;
    }

    @Override
    public Iterable<Client> findAll() {
        return null;
    }

    @Override
    public Client findById(UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}

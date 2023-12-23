package com.devsu.persistence.mapper;

import com.devsu.app.model.persistence.Client;
import com.devsu.persistence.entities.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {
    Client toModel(ClientEntity clientEntity);
    ClientEntity toEntity(Client client);
    Iterable<Client> map(Iterable<ClientEntity> clientEntities);
}

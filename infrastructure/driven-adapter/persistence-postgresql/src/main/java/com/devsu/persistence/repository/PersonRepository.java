package com.devsu.persistence.repository;

import com.devsu.persistence.entities.PersonEntity;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, UUID> {

}

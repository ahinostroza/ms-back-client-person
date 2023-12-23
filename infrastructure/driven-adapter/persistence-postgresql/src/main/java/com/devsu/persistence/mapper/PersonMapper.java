package com.devsu.persistence.mapper;

import com.devsu.app.model.persistence.Person;
import com.devsu.persistence.entities.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper {
    Person toModel(PersonEntity personEntity);
    PersonEntity toEntity(Person person);
    Iterable<Person> map(Iterable<PersonEntity> personEntities);
}

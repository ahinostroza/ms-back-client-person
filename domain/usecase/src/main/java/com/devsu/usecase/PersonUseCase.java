package com.devsu.usecase;

import com.devsu.app.model.config.DevsuException;
import com.devsu.app.model.persistence.Person;
import com.devsu.gateway.PersonGateway;
import com.devsu.helper.MessageHelper;
import com.devsu.helper.constant.ExceptionConstant;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
public class PersonUseCase {
    private final PersonGateway personGateway;
    private final MessageHelper messageHelper;

    public Person insertPerson(Person person) {
        return personGateway.insert(person);
    }

    public Iterable<Person> listPersons() {
        return personGateway.findAll();
    }

    public Person findByPersonId(UUID id) {
        if(!personGateway.existById(id))
            throw new DevsuException(HttpStatus.NOT_FOUND.value(), ExceptionConstant.DEV0002,
                    this.messageHelper.getMessage(ExceptionConstant.DEV0002));
        return personGateway.findById(id);
    }

    public Person updatePerson(Person person) {
        if(!personGateway.existById(person.getPersonId()))
            throw new DevsuException(HttpStatus.NOT_FOUND.value(), ExceptionConstant.DEV0002,
                    this.messageHelper.getMessage(ExceptionConstant.DEV0002));
        return personGateway.insert(person);
    }

    public void deletePerson(Person person) {
        if(!personGateway.existById(person.getPersonId()))
            throw new DevsuException(HttpStatus.NOT_FOUND.value(), ExceptionConstant.DEV0002,
                    this.messageHelper.getMessage(ExceptionConstant.DEV0002));
        personGateway.delete(person.getPersonId());
    }
}
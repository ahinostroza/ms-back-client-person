package com.devsu.app.rest;

import com.devsu.app.model.persistence.Person;
import com.devsu.app.rest.dto.CreatePersonDto;
import com.devsu.app.rest.dto.DeletePersonDto;
import com.devsu.app.rest.dto.UpdatePersonDto;
import com.devsu.app.rest.mapper.CreatePersonDtoMapper;
import com.devsu.app.rest.mapper.DeletePersonDtoMapper;
import com.devsu.app.rest.mapper.UpdatePersonDtoMapper;
import com.devsu.usecase.PersonUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Validated
@RestController
@RequestMapping("api/v1")
public class PersonController {
     private final PersonUseCase personUseCase;

     @GetMapping("/personas")
     @ResponseStatus(HttpStatus.OK)
     public Iterable<Person> getPerson() {
          return personUseCase.listPersons();
     }

     @GetMapping("/personas/{id}")
     @ResponseStatus(HttpStatus.OK)
     public Person getPersonById(@PathVariable(name = "id", required = true) UUID id) {
          return personUseCase.findByPersonId(id);
     }

     @PostMapping("/personas")
     @ResponseStatus(HttpStatus.OK)
     public Person createPerson(@Valid @RequestBody CreatePersonDto createPersonDto) {
          return personUseCase.insertPerson(CreatePersonDtoMapper.dtoToModel(createPersonDto));
     }

     @PutMapping("/personas")
     @ResponseStatus(HttpStatus.OK)
     public Person updatePerson(@Valid @RequestBody UpdatePersonDto updatePersonDto) {
          return personUseCase.updatePerson(UpdatePersonDtoMapper.dtoToModel(updatePersonDto));
     }

     @DeleteMapping("/personas")
     @ResponseStatus(HttpStatus.OK)
     public void deletePerson(@Valid @RequestBody DeletePersonDto deletePersonDto) {
          personUseCase.deletePerson(DeletePersonDtoMapper.dtoToModel(deletePersonDto));
     }
}
package com.devsu.app.rest.mapper;

import com.devsu.app.model.persistence.Person;
import com.devsu.app.rest.dto.CreatePersonDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CreatePersonDtoMapper {
    public static Person dtoToModel(CreatePersonDto createPersonDto) {
        return Person.builder()
                .name(createPersonDto.getName())
                .gender(createPersonDto.getGender())
                .age(createPersonDto.getAge())
                .document(createPersonDto.getDocument())
                .address(createPersonDto.getAddress())
                .phone(createPersonDto.getPhone())
                .build();
    }
}

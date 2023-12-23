package com.devsu.app.rest.mapper;

import com.devsu.app.model.persistence.Person;
import com.devsu.app.rest.dto.UpdatePersonDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UpdatePersonDtoMapper {
    public static Person dtoToModel(UpdatePersonDto updatePersonDto) {
        return Person.builder()
                .personId(updatePersonDto.getPersonId())
                .name(updatePersonDto.getName())
                .gender(updatePersonDto.getGender())
                .age(updatePersonDto.getAge())
                .document(updatePersonDto.getDocument())
                .address(updatePersonDto.getAddress())
                .phone(updatePersonDto.getPhone())
                .build();
    }
}

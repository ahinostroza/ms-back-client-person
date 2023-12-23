package com.devsu.app.rest.mapper;

import com.devsu.app.model.persistence.Person;
import com.devsu.app.rest.dto.DeletePersonDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DeletePersonDtoMapper {

    public static Person dtoToModel(DeletePersonDto deletePersonDto) {
        return Person.builder()
                .personId(deletePersonDto.getPersonId())
                .build();
    }
}

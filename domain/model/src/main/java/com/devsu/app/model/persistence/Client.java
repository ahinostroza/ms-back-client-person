package com.devsu.app.model.persistence;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Client {
    private UUID clientId;
    private String password;
    private Boolean status;
    private Person person;
}

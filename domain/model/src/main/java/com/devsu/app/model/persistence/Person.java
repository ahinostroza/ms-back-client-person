package com.devsu.app.model.persistence;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {
    private UUID personId;
    private String name;
    private String gender;
    private Integer age;
    private String document;
    private String address;
    private String phone;
}

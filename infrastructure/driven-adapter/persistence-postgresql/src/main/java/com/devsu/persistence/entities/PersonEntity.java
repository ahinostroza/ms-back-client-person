package com.devsu.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "person", schema = "public")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID personId;
    private String name;
    private String gender;
    private Integer age;
    private String document;
    private String address;
    private String phone;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private ClientEntity client;
}

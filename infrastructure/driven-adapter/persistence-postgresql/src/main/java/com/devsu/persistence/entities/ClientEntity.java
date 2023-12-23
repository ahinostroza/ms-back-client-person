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
@Table(name = "client", schema = "public")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID clientId;
    private String password;
    private Boolean status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personId")
    private PersonEntity person;
}

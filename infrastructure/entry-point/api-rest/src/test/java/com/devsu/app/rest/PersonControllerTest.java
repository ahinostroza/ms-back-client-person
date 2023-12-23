package com.devsu.app.rest;

import com.devsu.app.model.persistence.Person;
import com.devsu.usecase.PersonUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class PersonControllerTest {

    private static final String BASE_PATH = "/api/v1/";
    @Mock
    @Autowired
    MockMvc restMockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Mock
    PersonUseCase personUseCase;
    private Person person;
    private List<Person> personList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        objectMapper = new ObjectMapper();

        person = Person.builder()
                .personId(UUID.randomUUID())
                .name("Angel Jose")
                .gender("Masculino")
                .age(27)
                .document("72032902")
                .address("Urb. San Pedro F-32")
                .phone("932750359").build();

        personList = new ArrayList<>();
        personList.add(person);
    }

    @Test
    void getPerson() {
        /*when(personUseCase.listPersons())
                .thenReturn(personList);

        restMockMvc.perform(get(URI.create(BASE_PATH + "personas"))
                .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(personList)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/json")))
                .andExpect(jsonPath("$.size()", is(personList.size())));*/
    }
}

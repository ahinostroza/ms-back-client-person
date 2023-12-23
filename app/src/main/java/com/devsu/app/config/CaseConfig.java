package com.devsu.app.config;

import com.devsu.gateway.PersonGateway;
import com.devsu.helper.MessageHelper;
import com.devsu.usecase.PersonUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseConfig {

    @Bean
    public PersonUseCase personUseCase(PersonGateway personGateway, MessageHelper messageHelper) {
        return new PersonUseCase(personGateway, messageHelper);
    }
}

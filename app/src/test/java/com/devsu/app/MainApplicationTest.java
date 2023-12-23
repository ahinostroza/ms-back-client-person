package com.devsu.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class MainApplicationTest {
    @InjectMocks
    MainApplication mainApplication;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void printInfo() {
        MainApplication.printInfo();
        Assertions.assertNotNull(mainApplication);
    }
}

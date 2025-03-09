package com.example.belajar_spring_config_properties.appproperties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest(classes= ApplicationPropertiesTest.TestApplication.class)
public class ApplicationPropertiesTest {

    @Autowired
    Environment environment;

    @Test
    void testApplicationProperties() {
        String applicationName = environment.getProperty("application.name");
        Assertions.assertEquals("belajar-spring-config-properties", applicationName);

    }

    @SpringBootApplication
    public static class TestApplication {

    }
}

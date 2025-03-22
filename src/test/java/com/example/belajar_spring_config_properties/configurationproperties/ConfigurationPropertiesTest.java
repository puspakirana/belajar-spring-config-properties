package com.example.belajar_spring_config_properties.configurationproperties;

import com.example.belajar_spring_config_properties.properties.ApplicationProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest(classes = ConfigurationPropertiesTest.TestApplication.class)
public class ConfigurationPropertiesTest {

    @Autowired
    private ApplicationProperties properties;

    @Test
    void testConfigurationProperties() {
        Assertions.assertEquals("belajar-spring-config-properties", properties.getName());
        Assertions.assertEquals(1, properties.getVersion());
        Assertions.assertEquals(false, properties.isProductionMode());
    }

    @Test
    void testDatabaseProperties() {
        Assertions.assertEquals("eva", properties.getDatabase().getUsername());
        Assertions.assertEquals("rhs", properties.getDatabase().getPassword());
        Assertions.assertEquals("eva_db", properties.getDatabase().getDatabase());
        Assertions.assertEquals("jdbc::contoh", properties.getDatabase().getUrl());
    }

    @Test
    void testCollectionProperties() {
        Assertions.assertEquals(Arrays.asList("products", "customers", "categories"), properties.getDatabase().getWhitelistTables());
        Assertions.assertEquals(100, properties.getDatabase().getMaxTablesSize().get("products"));
        Assertions.assertEquals(100, properties.getDatabase().getMaxTablesSize().get("customers"));
        Assertions.assertEquals(100, properties.getDatabase().getMaxTablesSize().get("categories"));
    }

    @Test
    void testCollectionRoles() {
        Assertions.assertEquals("default", properties.getDefaultRoles().get(0).getId());
        Assertions.assertEquals("Default Role", properties.getDefaultRoles().get(0).getName());
        Assertions.assertEquals("guest", properties.getDefaultRoles().get(1).getId());
        Assertions.assertEquals("Guest Role", properties.getDefaultRoles().get(1).getName());

        Assertions.assertEquals("admin", properties.getRoles().get("admin").getId());
        Assertions.assertEquals("Admin Role", properties.getRoles().get("admin").getName());
        Assertions.assertEquals("finance", properties.getRoles().get("finance").getId());
        Assertions.assertEquals("Finance Role", properties.getRoles().get("finance").getName());
    }

    @SpringBootApplication
    @EnableConfigurationProperties({
            ApplicationProperties.class
    })
    public static class TestApplication {

    }
}

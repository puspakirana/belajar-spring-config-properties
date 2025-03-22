package com.example.belajar_spring_config_properties.profileproperties;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = ProfilePropertiesTest.TestApplication.class)
@ActiveProfiles({"prod", "test"})
public class ProfilePropertiesTest {

    @Autowired
    private TestApplication.ProfileProperties properties;

    @Test
    void testProfileProperties() {
        Assertions.assertEquals("Default", properties.getDefaultFile());
        Assertions.assertEquals("Production", properties.getProdFile());
        Assertions.assertEquals("Test", properties.getTestFile());
    }

    @SpringBootApplication
    public static class TestApplication {

        @Component
        public static class ProfileProperties {

            @Value("${profile.default}")
            private String defaultFile;

            @Value("${profile.prod}")
            private String prodFile;

            @Value("${profile.test}")
            private String testFile;

            public String getDefaultFile() {
                return this.defaultFile;
            }

            public String getProdFile() {
                return this.prodFile;
            }

            public String getTestFile() {
                return this.testFile;
            }

        }

    }
}

package com.example.belajar_spring_config_properties.value;

import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

@SpringBootTest(classes = ValueTest.TestApplication.class)
public class ValueTest {

    @Autowired
    private TestApplication.ApplicationProperties properties;

    @Autowired
    private TestApplication.SystemProperties systemProperties;

    @Test
    void testValue() {
        Assertions.assertEquals("belajar-spring-config-properties", properties.getName());
        Assertions.assertEquals(1, properties.getVersion());
        Assertions.assertEquals(false, properties.getProductionMode());
        Assertions.assertEquals("java_home", systemProperties.getJavaHome());
    }

    @SpringBootApplication
    public static class TestApplication {

        @Component
        public static class SystemProperties {
            @Value("${JAVA_HOME}")
            private String javaHome;

            public String getJavaHome() {
                return this.javaHome;
            }
        }

        @Component
        public static class ApplicationProperties {

            @Value("${application.name}")
            private String name;

            @Value("${application.version}")
            private Integer version;

            @Value("${application.production.mode}")
            private Boolean productionMode;

            public String getName() {
                return this.name;
            }

            public Integer getVersion() {
                return this.version;
            }

            public Boolean getProductionMode() {
                return this.productionMode;
            }
        }
    }
}

package environment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest(classes = EnvironmentTest.TestApplication.class)
public class EnvironmentTest {

    @Autowired
    Environment environment;

    @Test
    void testEnvironment() {
        String javaHome = environment.getProperty("JAVA_HOME");
        Assertions.assertEquals("java_home", javaHome);
    }

    @SpringBootApplication
    public static class TestApplication {

    }
}

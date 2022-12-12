package org.example.task1;

import static org.junit.jupiter.api.Assertions.*;
import org.example.task1.Client;
import org.example.task1.Constants;
import org.example.task1.TestClass;
import org.junit.jupiter.api.Test;
import java.io.IOException;

class TestTask1 {

    @Test
    void testClientServer() {
        try {
            Client client = new Client();
            client.connect(Constants.HOST, Constants.PORT);
            TestClass testClass = new TestClass("name", "surname", 19);

            String message = client.sendSerializedObject(null);
            assertEquals("Error, received null object!", message);

            message = client.sendSerializedObject(testClass);
            assertEquals("Object is deserialized", message);

            client.stop();
        } catch (IOException e) {
            fail();
        }
    }

}
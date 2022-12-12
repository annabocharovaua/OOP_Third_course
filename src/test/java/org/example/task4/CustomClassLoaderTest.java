package org.example.task4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.AbstractList;
import java.lang.reflect.Modifier;

class CustomClassLoaderTest {
    @Test
    void testClassLoaderOnJavaClass() {
        CustomClassLoader loader = new CustomClassLoader();

        try {
            Class<?> loadedClass = loader.loadClass("java.util.ArrayList");

            assertEquals(AbstractList.class, loadedClass.getSuperclass());

            int classModifiers = loadedClass.getModifiers();

            assertTrue(Modifier.isPublic(classModifiers));
            assertFalse(Modifier.isAbstract(classModifiers));
            assertFalse(Modifier.isFinal(classModifiers));

            assertEquals(4, loadedClass.getInterfaces().length);
        } catch (ClassNotFoundException e) {
            fail();
        }
    }


}
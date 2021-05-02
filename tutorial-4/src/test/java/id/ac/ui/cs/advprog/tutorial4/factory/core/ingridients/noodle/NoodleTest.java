package id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NoodleTest {
    private Class<?> noodleClass;

    @BeforeEach
    public void setup() throws Exception {
        noodleClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Noodle");
    }

    @Test
    public void testNoodleIsAPublicInterface() {
        int classModifiers = noodleClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));
        assertTrue(Modifier.isInterface(classModifiers));
    }

    @Test
    public void testNoodleHasGetDescriptionAbstractMethod() throws Exception {
        Method getDescription = noodleClass.getDeclaredMethod("getDescription");
        int methodModifiers = getDescription.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, getDescription.getParameterCount());
    }
}

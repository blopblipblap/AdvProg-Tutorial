package id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MeatTest {
    private Class<?> meatClass;

    @BeforeEach
    public void setup() throws Exception {
        meatClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Meat");
    }

    @Test
    public void testMeatIsAPublicInterface() {
        int classModifiers = meatClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));
        assertTrue(Modifier.isInterface(classModifiers));
    }

    @Test
    public void testMeatHasGetDescriptionAbstractMethod() throws Exception {
        Method getDescription = meatClass.getDeclaredMethod("getDescription");
        int methodModifiers = getDescription.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, getDescription.getParameterCount());
    }
}

package id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlavorTest {
    private Class<?> flavorClass;

    @BeforeEach
    public void setup() throws Exception {
        flavorClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Flavor");
    }

    @Test
    public void testFlavorIsAPublicInterface() {
        int classModifiers = flavorClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));
        assertTrue(Modifier.isInterface(classModifiers));
    }

    @Test
    public void testFlavorHasGetDescriptionAbstractMethod() throws Exception {
        Method getDescription = flavorClass.getDeclaredMethod("getDescription");
        int methodModifiers = getDescription.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, getDescription.getParameterCount());
    }
}

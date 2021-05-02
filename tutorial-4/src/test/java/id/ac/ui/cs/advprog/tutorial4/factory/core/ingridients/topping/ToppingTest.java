package id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ToppingTest {
    private Class<?> toppingClass;

    @BeforeEach
    public void setup() throws Exception {
        toppingClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Topping");
    }

    @Test
    public void testToppingIsAPublicInterface() {
        int classModifiers = toppingClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));
        assertTrue(Modifier.isInterface(classModifiers));
    }

    @Test
    public void testToppingHasGetDescriptionAbstractMethod() throws Exception {
        Method getDescription = toppingClass.getDeclaredMethod("getDescription");
        int methodModifiers = getDescription.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, getDescription.getParameterCount());
    }
}

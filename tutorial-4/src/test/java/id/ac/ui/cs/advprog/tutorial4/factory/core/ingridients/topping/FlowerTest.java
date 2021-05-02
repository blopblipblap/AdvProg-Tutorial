package id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class FlowerTest {
    private Class<?> flowerClass;

    @BeforeEach
    public void setUp() throws Exception {
        flowerClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Flower");
    }

    @Test
    public void testFlowerIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(flowerClass.getModifiers()));
    }

    @Test
    public void testFlowerIsATopping() {
        Collection<Type> interfaces = Arrays.asList(flowerClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Topping")));
    }

    @Test
    public void testFlowerOverrideGetDescriptionMethod() throws Exception {
        Method getDescription = flowerClass.getDeclaredMethod("getDescription");

        assertEquals("java.lang.String",
                getDescription.getGenericReturnType().getTypeName());
        assertEquals(0,
                getDescription.getParameterCount());
        assertTrue(Modifier.isPublic(getDescription.getModifiers()));
    }

    @Test
    public void testFlowerReturnValue() throws Exception {
        Topping flower = new Flower();

        String getDescription = flower.getDescription();

        assertThat(getDescription).isEqualTo("Adding Xinqin Flower Topping...");
    }
}

package id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Topping;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.BoiledEgg;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BoiledEggTest {
    private Class<?> boiledEggClass;

    @BeforeEach
    public void setUp() throws Exception {
        boiledEggClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.BoiledEgg");
    }

    @Test
    public void testBoiledEggIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(boiledEggClass.getModifiers()));
    }

    @Test
    public void testBoiledEggIsATopping() {
        Collection<Type> interfaces = Arrays.asList(boiledEggClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Topping")));
    }

    @Test
    public void testBoiledEggOverrideGetDescriptionMethod() throws Exception {
        Method getDescription = boiledEggClass.getDeclaredMethod("getDescription");

        assertEquals("java.lang.String",
                getDescription.getGenericReturnType().getTypeName());
        assertEquals(0,
                getDescription.getParameterCount());
        assertTrue(Modifier.isPublic(getDescription.getModifiers()));
    }

    @Test
    public void testBoiledEggReturnValue() throws Exception {
        Topping boiledEgg = new BoiledEgg();

        String getDescription = boiledEgg.getDescription();

        assertThat(getDescription).isEqualTo("Adding Guahuan Boiled Egg Topping");
    }
}

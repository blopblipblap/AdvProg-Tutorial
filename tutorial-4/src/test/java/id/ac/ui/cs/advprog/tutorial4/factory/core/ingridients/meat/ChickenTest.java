package id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ChickenTest {
    private Class<?> chickenClass;

    @BeforeEach
    public void setUp() throws Exception {
        chickenClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Chicken");
    }

    @Test
    public void testChickenIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(chickenClass.getModifiers()));
    }

    @Test
    public void testChickenIsAMeat() {
        Collection<Type> interfaces = Arrays.asList(chickenClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Meat")));
    }

    @Test
    public void testChickenOverrideGetDescriptionMethod() throws Exception {
        Method getDescription = chickenClass.getDeclaredMethod("getDescription");

        assertEquals("java.lang.String",
                getDescription.getGenericReturnType().getTypeName());
        assertEquals(0,
                getDescription.getParameterCount());
        assertTrue(Modifier.isPublic(getDescription.getModifiers()));
    }

    @Test
    public void testChickenReturnValue() throws Exception {
        Meat chicken = new Chicken();

        String getDescription = chicken.getDescription();

        assertThat(getDescription).isEqualTo("Adding Wintervale Chicken Meat...");
    }
}

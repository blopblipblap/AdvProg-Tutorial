package id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class SaltyTest {
    private Class<?> saltyClass;

    @BeforeEach
    public void setUp() throws Exception {
        saltyClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Salty");
    }

    @Test
    public void testSaltyIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(saltyClass.getModifiers()));
    }

    @Test
    public void testSaltyIsAFlavor() {
        Collection<Type> interfaces = Arrays.asList(saltyClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Flavor")));
    }

    @Test
    public void testSaltyOverrideGetDescriptionMethod() throws Exception {
        Method getDescription = saltyClass.getDeclaredMethod("getDescription");

        assertEquals("java.lang.String",
                getDescription.getGenericReturnType().getTypeName());
        assertEquals(0,
                getDescription.getParameterCount());
        assertTrue(Modifier.isPublic(getDescription.getModifiers()));
    }

    @Test
    public void testSaltyReturnValue() throws Exception {
        Flavor salty = new Salty();

        String getDescription = salty.getDescription();

        assertThat(getDescription).isEqualTo("Adding a pinch of salt...");
    }
}

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

public class SpicyTest {
    private Class<?> spicyClass;

    @BeforeEach
    public void setUp() throws Exception {
        spicyClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Spicy");
    }

    @Test
    public void testSpicyIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(spicyClass.getModifiers()));
    }

    @Test
    public void testSpicyIsAFlavor() {
        Collection<Type> interfaces = Arrays.asList(spicyClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Flavor")));
    }

    @Test
    public void testSpicyOverrideGetDescriptionMethod() throws Exception {
        Method getDescription = spicyClass.getDeclaredMethod("getDescription");

        assertEquals("java.lang.String",
                getDescription.getGenericReturnType().getTypeName());
        assertEquals(0,
                getDescription.getParameterCount());
        assertTrue(Modifier.isPublic(getDescription.getModifiers()));
    }

    @Test
    public void testSpicyReturnValue() throws Exception {
        Flavor spicy = new Spicy();

        String getDescription = spicy.getDescription();

        assertThat(getDescription).isEqualTo("Adding Liyuan Chili Powder...");
    }
}

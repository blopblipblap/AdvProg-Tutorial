package id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Flavor;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Salty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BeefTest {
    private Class<?> beefClass;

    @BeforeEach
    public void setUp() throws Exception {
        beefClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Beef");
    }

    @Test
    public void testBeefIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(beefClass.getModifiers()));
    }

    @Test
    public void testBeefIsAMeat() {
        Collection<Type> interfaces = Arrays.asList(beefClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Meat")));
    }

    @Test
    public void testBeefOverrideGetDescriptionMethod() throws Exception {
        Method getDescription = beefClass.getDeclaredMethod("getDescription");

        assertEquals("java.lang.String",
                getDescription.getGenericReturnType().getTypeName());
        assertEquals(0,
                getDescription.getParameterCount());
        assertTrue(Modifier.isPublic(getDescription.getModifiers()));
    }

    @Test
    public void testBeefReturnValue() throws Exception {
        Meat beef = new Beef();

        String getDescription = beef.getDescription();

        assertThat(getDescription).isEqualTo("Adding Maro Beef Meat...");
    }
}

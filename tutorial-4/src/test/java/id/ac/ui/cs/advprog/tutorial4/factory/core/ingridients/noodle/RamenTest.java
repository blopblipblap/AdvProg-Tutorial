package id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Ramen;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Noodle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class RamenTest {
    private Class<?> ramenClass;

    @BeforeEach
    public void setUp() throws Exception {
        ramenClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Ramen");
    }

    @Test
    public void testRamenIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(ramenClass.getModifiers()));
    }

    @Test
    public void testRamenIsANoodle() {
        Collection<Type> interfaces = Arrays.asList(ramenClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Noodle")));
    }

    @Test
    public void testRamenOverrideGetDescriptionMethod() throws Exception {
        Method getDescription = ramenClass.getDeclaredMethod("getDescription");

        assertEquals("java.lang.String",
                getDescription.getGenericReturnType().getTypeName());
        assertEquals(0,
                getDescription.getParameterCount());
        assertTrue(Modifier.isPublic(getDescription.getModifiers()));
    }

    @Test
    public void testRamenReturnValue() throws Exception {
        Noodle ramen = new Ramen();

        String getDescription = ramen.getDescription();

        assertThat(getDescription).isEqualTo("Adding Inuzuma Ramen Noodles...");
    }
}

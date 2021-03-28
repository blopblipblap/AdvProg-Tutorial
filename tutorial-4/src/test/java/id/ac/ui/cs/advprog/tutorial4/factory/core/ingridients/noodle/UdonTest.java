package id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class UdonTest {
    private Class<?> udonClass;

    @BeforeEach
    public void setUp() throws Exception {
        udonClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Udon");
    }

    @Test
    public void testUdonIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(udonClass.getModifiers()));
    }

    @Test
    public void testUdonIsANoodle() {
        Collection<Type> interfaces = Arrays.asList(udonClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Noodle")));
    }

    @Test
    public void testUdonOverrideGetDescriptionMethod() throws Exception {
        Method getDescription = udonClass.getDeclaredMethod("getDescription");

        assertEquals("java.lang.String",
                getDescription.getGenericReturnType().getTypeName());
        assertEquals(0,
                getDescription.getParameterCount());
        assertTrue(Modifier.isPublic(getDescription.getModifiers()));
    }

    @Test
    public void testUdonReturnValue() throws Exception {
        Noodle udon = new Udon();

        String getDescription = udon.getDescription();

        assertThat(getDescription).isEqualTo("Adding Mondo Udon Noodles...");
    }
}
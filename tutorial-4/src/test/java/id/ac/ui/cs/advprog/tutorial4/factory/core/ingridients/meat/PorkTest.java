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

public class PorkTest {
    private Class<?> porkClass;

    @BeforeEach
    public void setUp() throws Exception {
        porkClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Pork");
    }

    @Test
    public void testPorkIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(porkClass.getModifiers()));
    }

    @Test
    public void testPorkIsAMeat() {
        Collection<Type> interfaces = Arrays.asList(porkClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Meat")));
    }

    @Test
    public void testPorkOverrideGetDescriptionMethod() throws Exception {
        Method getDescription = porkClass.getDeclaredMethod("getDescription");

        assertEquals("java.lang.String",
                getDescription.getGenericReturnType().getTypeName());
        assertEquals(0,
                getDescription.getParameterCount());
        assertTrue(Modifier.isPublic(getDescription.getModifiers()));
    }

    @Test
    public void testPorkReturnValue() throws Exception {
        Meat pork = new Pork();

        String getDescription = pork.getDescription();

        assertThat(getDescription).isEqualTo("Adding Tian Xu Pork Meat...");
    }
}

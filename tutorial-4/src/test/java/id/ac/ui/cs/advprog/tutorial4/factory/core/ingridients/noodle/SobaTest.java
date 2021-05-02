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

public class SobaTest {
    private Class<?> sobaClass;

    @BeforeEach
    public void setUp() throws Exception {
        sobaClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Soba");
    }

    @Test
    public void testSobaIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(sobaClass.getModifiers()));
    }

    @Test
    public void testSobaIsANoodle() {
        Collection<Type> interfaces = Arrays.asList(sobaClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Noodle")));
    }

    @Test
    public void testSobaOverrideGetDescriptionMethod() throws Exception {
        Method getDescription = sobaClass.getDeclaredMethod("getDescription");

        assertEquals("java.lang.String",
                getDescription.getGenericReturnType().getTypeName());
        assertEquals(0,
                getDescription.getParameterCount());
        assertTrue(Modifier.isPublic(getDescription.getModifiers()));
    }

    @Test
    public void testSobaReturnValue() throws Exception {
        Noodle soba = new Soba();

        String getDescription = soba.getDescription();

        assertThat(getDescription).isEqualTo("Adding Liyuan Soba Noodles...");
    }
}

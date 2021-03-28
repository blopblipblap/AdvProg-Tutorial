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

public class ShiratakiTest {
    private Class<?> shiratakiClass;

    @BeforeEach
    public void setUp() throws Exception {
        shiratakiClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Shirataki");
    }

    @Test
    public void testShiratakiIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(shiratakiClass.getModifiers()));
    }

    @Test
    public void testShiratakiIsANoodle() {
        Collection<Type> interfaces = Arrays.asList(shiratakiClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Noodle")));
    }

    @Test
    public void testShiratakiOverrideGetDescriptionMethod() throws Exception {
        Method getDescription = shiratakiClass.getDeclaredMethod("getDescription");

        assertEquals("java.lang.String",
                getDescription.getGenericReturnType().getTypeName());
        assertEquals(0,
                getDescription.getParameterCount());
        assertTrue(Modifier.isPublic(getDescription.getModifiers()));
    }

    @Test
    public void testShiratakiReturnValue() throws Exception {
        Noodle shirataki = new Shirataki();

        String getDescription = shirataki.getDescription();

        assertThat(getDescription).isEqualTo("Adding Snevnezha Shirataki Noodles...");
    }
}

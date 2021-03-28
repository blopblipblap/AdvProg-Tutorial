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

public class SweetTest {
    private Class<?> sweetClass;

    @BeforeEach
    public void setUp() throws Exception {
        sweetClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Sweet");
    }

    @Test
    public void testSweetIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(sweetClass.getModifiers()));
    }

    @Test
    public void testSweetIsAFlavor() {
        Collection<Type> interfaces = Arrays.asList(sweetClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Flavor")));
    }

    @Test
    public void testSweetOverrideGetDescriptionMethod() throws Exception {
        Method getDescription = sweetClass.getDeclaredMethod("getDescription");

        assertEquals("java.lang.String",
                getDescription.getGenericReturnType().getTypeName());
        assertEquals(0,
                getDescription.getParameterCount());
        assertTrue(Modifier.isPublic(getDescription.getModifiers()));
    }

    @Test
    public void testSweetReturnValue() throws Exception {
        Flavor sweet = new Sweet();

        String getDescription = sweet.getDescription();

        assertThat(getDescription).isEqualTo("Adding a dash of Sweet Soy Sauce...");
    }
}

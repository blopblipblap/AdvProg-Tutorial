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

public class UmamiTest {
    private Class<?> umamiClass;

    @BeforeEach
    public void setUp() throws Exception {
        umamiClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Umami");
    }

    @Test
    public void testUmamiIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(umamiClass.getModifiers()));
    }

    @Test
    public void testUmamiIsAFlavor() {
        Collection<Type> interfaces = Arrays.asList(umamiClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Flavor")));
    }

    @Test
    public void testUmamiOverrideGetDescriptionMethod() throws Exception {
        Method getDescription = umamiClass.getDeclaredMethod("getDescription");

        assertEquals("java.lang.String",
                getDescription.getGenericReturnType().getTypeName());
        assertEquals(0,
                getDescription.getParameterCount());
        assertTrue(Modifier.isPublic(getDescription.getModifiers()));
    }

    @Test
    public void testUmamiReturnValue() throws Exception {
        Flavor umami = new Umami();

        String getDescription = umami.getDescription();

        assertThat(getDescription).isEqualTo("Adding WanPlus Specialty MSG flavoring...");
    }
}

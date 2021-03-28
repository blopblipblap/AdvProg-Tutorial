package id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class MushroomTest {
    private Class<?> mushroomClass;

    @BeforeEach
    public void setUp() throws Exception {
        mushroomClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Mushroom");
    }

    @Test
    public void testMushroomIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(mushroomClass.getModifiers()));
    }

    @Test
    public void testMushroomIsATopping() {
        Collection<Type> interfaces = Arrays.asList(mushroomClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Topping")));
    }

    @Test
    public void testMushroomOverrideGetDescriptionMethod() throws Exception {
        Method getDescription = mushroomClass.getDeclaredMethod("getDescription");

        assertEquals("java.lang.String",
                getDescription.getGenericReturnType().getTypeName());
        assertEquals(0,
                getDescription.getParameterCount());
        assertTrue(Modifier.isPublic(getDescription.getModifiers()));
    }

    @Test
    public void testMushroomReturnValue() throws Exception {
        Topping mushroom = new Mushroom();

        String getDescription = mushroom.getDescription();

        assertThat(getDescription).isEqualTo("Adding Shiitake Mushroom Topping...");
    }
}

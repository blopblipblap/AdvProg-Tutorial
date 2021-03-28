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

public class CheeseTest {
    private Class<?> cheeseClass;

    @BeforeEach
    public void setUp() throws Exception {
        cheeseClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Cheese");
    }

    @Test
    public void testCheeseIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(cheeseClass.getModifiers()));
    }

    @Test
    public void testCheeseIsATopping() {
        Collection<Type> interfaces = Arrays.asList(cheeseClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Topping")));
    }

    @Test
    public void testCheeseOverrideGetDescriptionMethod() throws Exception {
        Method getDescription = cheeseClass.getDeclaredMethod("getDescription");

        assertEquals("java.lang.String",
                getDescription.getGenericReturnType().getTypeName());
        assertEquals(0,
                getDescription.getParameterCount());
        assertTrue(Modifier.isPublic(getDescription.getModifiers()));
    }

    @Test
    public void testCheeseReturnValue() throws Exception {
        Topping cheese = new Cheese();

        String getDescription = cheese.getDescription();

        assertThat(getDescription).isEqualTo("Adding Shredded Cheese Topping...");
    }
}

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

public class FishTest {
    private Class<?> fishClass;

    @BeforeEach
    public void setUp() throws Exception {
        fishClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Fish");
    }

    @Test
    public void testFishIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(fishClass.getModifiers()));
    }

    @Test
    public void testFishIsAMeat() {
        Collection<Type> interfaces = Arrays.asList(fishClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Meat")));
    }

    @Test
    public void testFishOverrideGetDescriptionMethod() throws Exception {
        Method getDescription = fishClass.getDeclaredMethod("getDescription");

        assertEquals("java.lang.String",
                getDescription.getGenericReturnType().getTypeName());
        assertEquals(0,
                getDescription.getParameterCount());
        assertTrue(Modifier.isPublic(getDescription.getModifiers()));
    }

    @Test
    public void testfishReturnValue() throws Exception {
        Meat fish = new Fish();

        String getDescription = fish.getDescription();

        assertThat(getDescription).isEqualTo("Adding Zhangyun Salmon Fish Meat...");
    }
}

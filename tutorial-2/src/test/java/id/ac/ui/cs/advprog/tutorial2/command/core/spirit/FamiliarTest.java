package id.ac.ui.cs.advprog.tutorial2.command.core.spirit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FamiliarTest {

    private Class<?> familiarClass;

    private Familiar familiar;

    @BeforeEach
    public void setup() throws Exception {
        familiarClass = Class.forName("id.ac.ui.cs.advprog.tutorial2.command.core.spirit.Familiar");
    }

    @Test
    public void testFamiliarIsConcreteClass() {
        assertFalse(Modifier.isAbstract(familiarClass.getModifiers()));
    }

    @Test
    public void testFamiliarGetPrevStateMethod() throws Exception {
        Method getPrevState = familiarClass.getDeclaredMethod("getPrevState");

        assertEquals("id.ac.ui.cs.advprog.tutorial2.command.core.spirit.FamiliarState",
                getPrevState.getGenericReturnType().getTypeName());
        assertEquals(0, getPrevState.getParameterCount());
    }

    @Test
    public void testFamiliarGetRaceMethod() throws Exception {
        Method getRace = familiarClass.getDeclaredMethod("getRace");

        assertEquals("java.lang.String", getRace.getGenericReturnType().getTypeName());
        assertEquals(0, getRace.getParameterCount());
    }

}

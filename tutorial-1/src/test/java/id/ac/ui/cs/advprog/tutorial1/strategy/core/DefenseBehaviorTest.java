package id.ac.ui.cs.advprog.tutorial1.strategy.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DefenseBehaviorTest {

    private Class<?> defenseBehavior;

    @BeforeEach
    public void setUp() throws Exception {
        defenseBehavior = Class.forName("id.ac.ui.cs.advprog.tutorial1.strategy.core.DefenseBehavior");
    }

    @Test
    public void testDefenseBehaviorIsAPublicInterface() {
        int classModifiers = defenseBehavior.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));
        assertTrue(Modifier.isInterface(classModifiers));
    }

    @Test
    public void testDefenseBehaviorHasDefendAbstractMethod() throws Exception {
        Method defend = defenseBehavior.getDeclaredMethod("defend");
        int methodModifiers = defend.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, defend.getParameterCount());
        assertEquals("java.lang.String", defend.getGenericReturnType().getTypeName());
    }
}

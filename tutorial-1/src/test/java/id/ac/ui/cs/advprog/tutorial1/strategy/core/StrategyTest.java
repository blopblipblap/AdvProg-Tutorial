package id.ac.ui.cs.advprog.tutorial1.strategy.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class StrategyTest {

    private Class<?> strategyClass;

    @BeforeEach
    public void setUp() throws Exception {
        strategyClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.strategy.core.Strategy");
    }

    @Test
    public void testStrategyIsAPublicInterface() {
        int classModifiers = strategyClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));
        assertTrue(Modifier.isInterface(classModifiers));
    }

    @Test
    public void testStrategyHasGetTypeAbstractMethod() throws Exception {
        Method getType = strategyClass.getDeclaredMethod("getType");
        int methodModifiers = getType.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, getType.getParameterCount());
        assertEquals("java.lang.String", getType.getGenericReturnType().getTypeName());
    }
}

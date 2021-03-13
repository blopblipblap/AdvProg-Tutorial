package id.ac.ui.cs.advprog.tutorial1.strategy.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DefendWithBarrierTest {

    private Class<?> defendWithBarrierClass;

    @BeforeEach
    public void setUp() throws Exception {
        defendWithBarrierClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.strategy.core.DefendWithBarrier");
    }

    @Test
    public void testDefendWithBarrierIsADefenseBehavior() {
        Collection<Type> interfaces = Arrays.asList(defendWithBarrierClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial1.strategy.core.DefenseBehavior")));
    }

    @Test
    public void testDefendWithBarrierOverrideDefendMethod() throws Exception {
        Method defend = defendWithBarrierClass.getDeclaredMethod("defend");

        assertTrue(Modifier.isPublic(defend.getModifiers()));
        assertEquals("java.lang.String", defend.getGenericReturnType().getTypeName());
    }
}

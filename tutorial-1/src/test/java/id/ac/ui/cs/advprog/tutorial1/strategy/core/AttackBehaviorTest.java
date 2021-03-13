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

public class AttackBehaviorTest {

    private Class<?> attackBehavior;

    @BeforeEach
    public void setUp() throws Exception {
        attackBehavior = Class.forName("id.ac.ui.cs.advprog.tutorial1.strategy.core.AttackBehavior");
    }

    @Test
    public void testAttackBehaviorIsAPublicInterface() {
        int classModifiers = attackBehavior.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));
        assertTrue(Modifier.isInterface(classModifiers));
    }

    @Test
    public void testAttackBehaviorIsStrategy() {
        Collection<Type> interfaces = Arrays.asList(attackBehavior.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial1.strategy.core.Strategy")));
    }

    @Test
    public void testAttackBehaviorHasAttackAbstractMethod() throws Exception {
        Method attack = attackBehavior.getDeclaredMethod("attack");
        int methodModifiers = attack.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, attack.getParameterCount());
        assertEquals("java.lang.String", attack.getGenericReturnType().getTypeName());
    }
}

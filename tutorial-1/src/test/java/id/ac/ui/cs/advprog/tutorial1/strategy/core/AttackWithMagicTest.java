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

public class AttackWithMagicTest {

    private Class<?> attackWithMagicClass;

    @BeforeEach
    public void setUp() throws Exception {
        attackWithMagicClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.strategy.core.AttackWithMagic");
    }

    @Test
    public void testAttackWithMagicIsAnAttackBehavior() {
        Collection<Type> interfaces = Arrays.asList(attackWithMagicClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial1.strategy.core.AttackBehavior")));
    }

    @Test
    public void testAttackWithMagicOverrideAttackMethod() throws Exception {
        Method attack = attackWithMagicClass.getDeclaredMethod("attack");

        assertTrue(Modifier.isPublic(attack.getModifiers()));
        assertEquals("java.lang.String", attack.getGenericReturnType().getTypeName());
    }
}

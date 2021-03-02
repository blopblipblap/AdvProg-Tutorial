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

public class AttackWithSwordTest {

    private Class<?> attackWithSwordClass;

    @BeforeEach
    public void setUp() throws Exception {
        attackWithSwordClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.strategy.core.AttackWithSword");
    }

    @Test
    public void testAttackWithSwordIsAnAttackBehavior() {
        Collection<Type> interfaces = Arrays.asList(attackWithSwordClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial1.strategy.core.AttackBehavior")));
    }

    @Test
    public void testAttackWithSwordOverrideAttackMethod() throws Exception {
        Method attack = attackWithSwordClass.getDeclaredMethod("attack");

        assertTrue(Modifier.isPublic(attack.getModifiers()));
        assertEquals("java.lang.String", attack.getGenericReturnType().getTypeName());
    }
}

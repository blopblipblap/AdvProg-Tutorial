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

public class AttackWithGunTest {

    private Class<?> attackWithGunClass;

    @BeforeEach
    public void setUp() throws Exception {
        attackWithGunClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.strategy.core.AttackWithGun");
    }

    @Test
    public void testAttackWithGunIsAnAttackBehavior() {
        Collection<Type> interfaces = Arrays.asList(attackWithGunClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial1.strategy.core.AttackBehavior")));
    }

    @Test
    public void testAttackWithGunOverrideAttackMethod() throws Exception {
        Method attack = attackWithGunClass.getDeclaredMethod("attack");

        assertTrue(Modifier.isPublic(attack.getModifiers()));
        assertEquals("java.lang.String", attack.getGenericReturnType().getTypeName());
    }
}

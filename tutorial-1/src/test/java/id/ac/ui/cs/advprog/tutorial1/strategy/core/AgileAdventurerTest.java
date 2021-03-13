package id.ac.ui.cs.advprog.tutorial1.strategy.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AgileAdventurerTest {

    private Class<?> agileAdventurerClass;

    @BeforeEach
    public void setUp() throws Exception {
        agileAdventurerClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.strategy.core.AgileAdventurer");
    }

    @Test
    public void testAgileAdventurerIsConcreteClass() {
        assertFalse(Modifier.isAbstract(agileAdventurerClass.getModifiers()));
    }

    @Test
    public void testAgileAdventurerIsAnAdventurer() {
        Class<?> parentClass = agileAdventurerClass.getSuperclass();

        assertEquals("id.ac.ui.cs.advprog.tutorial1.strategy.core.Adventurer",
                parentClass.getName());
    }

    @Test
    public void testAgileAdventurerGetAliasMethodReturnsAgile() throws Exception {
        Method getAlias = agileAdventurerClass.getDeclaredMethod("getAlias");

        assertEquals("java.lang.String", getAlias.getGenericReturnType().getTypeName());
        assertEquals(0, getAlias.getParameterCount());
    }

    @Test
    public void testNewAgileAdventurerUsesGunAsDefault() {
        AgileAdventurer agileAdventurer = new AgileAdventurer();

        assertEquals("id.ac.ui.cs.advprog.tutorial1.strategy.core.AttackWithGun",
                agileAdventurer.getAttackBehavior().getClass().getName());
    }

    @Test
    public void testNewAgileAdventurerUsesBarrierAsDefault() {
        AgileAdventurer agileAdventurer = new AgileAdventurer();

        assertEquals("id.ac.ui.cs.advprog.tutorial1.strategy.core.DefendWithBarrier",
                agileAdventurer.getDefenseBehavior().getClass().getName());
    }
}

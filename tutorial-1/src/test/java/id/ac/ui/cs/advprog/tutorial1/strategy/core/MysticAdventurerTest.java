package id.ac.ui.cs.advprog.tutorial1.strategy.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MysticAdventurerTest {

    private Class<?> mysticAdventurerClass;

    @BeforeEach
    public void setUp() throws Exception {
        mysticAdventurerClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.strategy.core.MysticAdventurer");
    }

    @Test
    public void testMysticAdventurerIsConcreteClass() {
        assertFalse(Modifier.isAbstract(mysticAdventurerClass.getModifiers()));
    }

    @Test
    public void testMysticAdventurerIsAnAdventurer() {
        Class<?> parentClass = mysticAdventurerClass.getSuperclass();

        assertEquals("id.ac.ui.cs.advprog.tutorial1.strategy.core.Adventurer",
                parentClass.getName());
    }

    @Test
    public void testMysticAdventurerGetAliasMethodReturnsAgile() throws Exception {
        Method getAlias = mysticAdventurerClass.getDeclaredMethod("getAlias");

        assertEquals("java.lang.String", getAlias.getGenericReturnType().getTypeName());
        assertEquals(0, getAlias.getParameterCount());
    }

    @Test
    public void testNewMysticAdventurerUsesMagicAsDefault() {
        MysticAdventurer agileAdventurer = new MysticAdventurer();

        assertEquals("id.ac.ui.cs.advprog.tutorial1.strategy.core.AttackWithMagic",
                agileAdventurer.getAttackBehavior().getClass().getName());
    }

    @Test
    public void testNewMysticAdventurerUsesShieldAsDefault() {
        MysticAdventurer agileAdventurer = new MysticAdventurer();

        assertEquals("id.ac.ui.cs.advprog.tutorial1.strategy.core.DefendWithShield",
                agileAdventurer.getDefenseBehavior().getClass().getName());
    }
}

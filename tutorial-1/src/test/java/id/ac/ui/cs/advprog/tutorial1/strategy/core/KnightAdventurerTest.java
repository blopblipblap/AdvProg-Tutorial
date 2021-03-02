package id.ac.ui.cs.advprog.tutorial1.strategy.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class KnightAdventurerTest {

    private Class<?> knightAdventurerClass;

    @BeforeEach
    public void setUp() throws Exception {
        knightAdventurerClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.strategy.core.KnightAdventurer");
    }

    @Test
    public void testKnightAdventurerIsConcreteClass() {
        assertFalse(Modifier.isAbstract(knightAdventurerClass.getModifiers()));
    }

    @Test
    public void testKnightAdventurerIsAnAdventurer() {
        Class<?> parentClass = knightAdventurerClass.getSuperclass();

        assertEquals("id.ac.ui.cs.advprog.tutorial1.strategy.core.Adventurer",
                parentClass.getName());
    }

    @Test
    public void testKnightAdventurerGetAliasMethodReturnsKnight() throws Exception {
        Method getAlias = knightAdventurerClass.getDeclaredMethod("getAlias");

        assertEquals("java.lang.String", getAlias.getGenericReturnType().getTypeName());
        assertEquals(0, getAlias.getParameterCount());
    }

    @Test
    public void testNewKnightAdventurerUsesSwordAsDefault() {
        KnightAdventurer agileAdventurer = new KnightAdventurer();

        assertEquals("id.ac.ui.cs.advprog.tutorial1.strategy.core.AttackWithSword",
                agileAdventurer.getAttackBehavior().getClass().getName());
    }

    @Test
    public void testNewKnightAdventurerUsesArmorAsDefault() {
        KnightAdventurer agileAdventurer = new KnightAdventurer();

        assertEquals("id.ac.ui.cs.advprog.tutorial1.strategy.core.DefendWithArmor",
                agileAdventurer.getDefenseBehavior().getClass().getName());
    }
}

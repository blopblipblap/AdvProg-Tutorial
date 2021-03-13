package id.ac.ui.cs.advprog.tutorial1.strategy.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdventurerTest {

    private Class<?> adventurerClass;

    @BeforeEach
    public void setUp() throws Exception {
        adventurerClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.strategy.core.Adventurer");
    }

    @Test
    public void testAdventurerIsAbstract() {
        assertTrue(Modifier.isAbstract(adventurerClass.getModifiers()));
    }

    @Test
    public void testAdventurerHasAttackMethod() throws Exception {
        Method attack = adventurerClass.getDeclaredMethod("attack");

        assertTrue(Modifier.isPublic(attack.getModifiers()));
        assertEquals(0, attack.getParameterCount());
        assertEquals("java.lang.String", attack.getGenericReturnType().getTypeName());
    }

    @Test
    public void testAdventurerHasDefendMethod() throws Exception {
        Method defend = adventurerClass.getDeclaredMethod("defend");

        assertTrue(Modifier.isPublic(defend.getModifiers()));
        assertEquals(0, defend.getParameterCount());
        assertEquals("java.lang.String", defend.getGenericReturnType().getTypeName());
    }

    @Test
    public void testAdventurerHasAttackBehaviorSetter() throws Exception {
        Method setAttackBehavior = adventurerClass.getDeclaredMethod("setAttackBehavior",
                AttackBehavior.class);

        assertTrue(Modifier.isPublic(setAttackBehavior.getModifiers()));
        assertEquals(1, setAttackBehavior.getParameterCount());
        assertEquals("void", setAttackBehavior.getGenericReturnType().getTypeName());
    }

    @Test
    public void testAdventurerHasAttackBehaviorGetter() throws Exception {
        Method getAttackBehavior = adventurerClass.getDeclaredMethod("getAttackBehavior");

        assertTrue(Modifier.isPublic(getAttackBehavior.getModifiers()));
        assertEquals(0, getAttackBehavior.getParameterCount());
        assertEquals(AttackBehavior.class, getAttackBehavior.getGenericReturnType());
    }

    @Test
    public void testAdventurerHasDefenseBehaviorSetter() throws Exception {
        Method setDefenseBehavior = adventurerClass.getDeclaredMethod("setDefenseBehavior",
                DefenseBehavior.class);

        assertTrue(Modifier.isPublic(setDefenseBehavior.getModifiers()));
        assertEquals(1, setDefenseBehavior.getParameterCount());
        assertEquals("void", setDefenseBehavior.getGenericReturnType().getTypeName());
    }

    @Test
    public void testAdventurerHasDefenseBehaviorGetter() throws Exception {
        Method getDefenseBehavior = adventurerClass.getDeclaredMethod("getDefenseBehavior");

        assertTrue(Modifier.isPublic(getDefenseBehavior.getModifiers()));
        assertEquals(0, getDefenseBehavior.getParameterCount());
        assertEquals(DefenseBehavior.class, getDefenseBehavior.getGenericReturnType());
    }
}

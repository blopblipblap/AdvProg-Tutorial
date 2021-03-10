package id.ac.ui.cs.advprog.tutorial2.template.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LancerTest {

    private Class<?> lancerClass;

    @BeforeEach
    public void setUp() throws Exception {
        lancerClass = Class.forName("id.ac.ui.cs.advprog.tutorial2.template.core.Lancer");
    }

    @Test
    public void testLancerIsConcreteClass() {
        assertFalse(Modifier.isAbstract(lancerClass.getModifiers()));
    }

    @Test
    public void testLancerIsAnSpiritInRequest() {
        Class<?> parentClass = lancerClass.getSuperclass();

        assertEquals("id.ac.ui.cs.advprog.tutorial2.template.core.SpiritInQuest",
                parentClass.getName());
    }

    @Test
    public void testOverrideBuff() throws Exception {
        Method buff = lancerClass.getDeclaredMethod("buff");

        assertEquals("java.lang.String", buff.getGenericReturnType().getTypeName());
        assertEquals(0, buff.getParameterCount());
    }

    @Test
    public void testOverrideAttackWithBuster() throws Exception {
        Method attackWithBuster = lancerClass.getDeclaredMethod("attackWithBuster");

        assertEquals("java.lang.String", attackWithBuster.getGenericReturnType().getTypeName());
        assertEquals(0, attackWithBuster.getParameterCount());
    }

    @Test
    public void testOverrideAttackWithQuick() throws Exception {
        Method attackWithQuick = lancerClass.getDeclaredMethod("attackWithQuick");

        assertEquals("java.lang.String", attackWithQuick.getGenericReturnType().getTypeName());
        assertEquals(0, attackWithQuick.getParameterCount());
    }

    @Test
    public void testOverrideAttackWithArts() throws Exception {
        Method attackWithArts = lancerClass.getDeclaredMethod("attackWithArts");

        assertEquals("java.lang.String", attackWithArts.getGenericReturnType().getTypeName());
        assertEquals(0, attackWithArts.getParameterCount());
    }

    @Test
    public void testOverrideAttackWithSpecialSkill() throws Exception {
        Method attackWithSpecialSkill = lancerClass.getDeclaredMethod("attackWithSpecialSkill");

        assertEquals("java.lang.String", attackWithSpecialSkill.getGenericReturnType().getTypeName());
        assertEquals(0, attackWithSpecialSkill.getParameterCount());
    }
}

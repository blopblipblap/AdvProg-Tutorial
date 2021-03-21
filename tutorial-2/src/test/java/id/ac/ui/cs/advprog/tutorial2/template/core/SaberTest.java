package id.ac.ui.cs.advprog.tutorial2.template.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SaberTest {

    private Class<?> saberClass;

    @BeforeEach
    public void setUp() throws Exception {
        saberClass = Class.forName("id.ac.ui.cs.advprog.tutorial2.template.core.Saber");
    }

    @Test
    public void testSaberIsConcreteClass() {
        assertFalse(Modifier.isAbstract(saberClass.getModifiers()));
    }

    @Test
    public void testSaberIsAnSpiritInRequest() {
        Class<?> parentClass = saberClass.getSuperclass();

        assertEquals("id.ac.ui.cs.advprog.tutorial2.template.core.SpiritInQuest",
                parentClass.getName());
    }

    @Test
    public void testOverrideBuff() throws Exception {
        Method buff = saberClass.getDeclaredMethod("buff");

        assertEquals("java.lang.String", buff.getGenericReturnType().getTypeName());
        assertEquals(0, buff.getParameterCount());
    }

    @Test
    public void testOverrideAttackWithBuster() throws Exception {
        Method attackWithBuster = saberClass.getDeclaredMethod("attackWithBuster");

        assertEquals("java.lang.String", attackWithBuster.getGenericReturnType().getTypeName());
        assertEquals(0, attackWithBuster.getParameterCount());
    }

    @Test
    public void testOverrideAttackWithQuick() throws Exception {
        Method attackWithQuick = saberClass.getDeclaredMethod("attackWithQuick");

        assertEquals("java.lang.String", attackWithQuick.getGenericReturnType().getTypeName());
        assertEquals(0, attackWithQuick.getParameterCount());
    }

    @Test
    public void testOverrideAttackWithArts() throws Exception {
        Method attackWithArts = saberClass.getDeclaredMethod("attackWithArts");

        assertEquals("java.lang.String", attackWithArts.getGenericReturnType().getTypeName());
        assertEquals(0, attackWithArts.getParameterCount());
    }

    @Test
    public void testOverrideAttackWithSpecialSkill() throws Exception {
        Method attackWithSpecialSkill = saberClass.getDeclaredMethod("attackWithSpecialSkill");

        assertEquals("java.lang.String", attackWithSpecialSkill.getGenericReturnType().getTypeName());
        assertEquals(0, attackWithSpecialSkill.getParameterCount());
    }
}

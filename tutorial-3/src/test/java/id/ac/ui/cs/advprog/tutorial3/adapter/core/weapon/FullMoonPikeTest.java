package id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

// TODO: add tests
public class FullMoonPikeTest {
    private Class<?> fullMoonPikeClass;

    @BeforeEach
    public void setUp() throws Exception {
        fullMoonPikeClass = Class.forName("id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.FullMoonPike");
    }

    @Test
    public void testFullMoonPikeIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(fullMoonPikeClass.getModifiers()));
    }

    @Test
    public void testFullMoonPikeIsAWeapon() {
        Collection<Type> interfaces = Arrays.asList(fullMoonPikeClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.Weapon")));
    }

    @Test
    public void testFullMoonPikeOverrideNormalAttackMethod() throws Exception {
        Method normalAttack = fullMoonPikeClass.getDeclaredMethod("normalAttack");

        assertEquals("java.lang.String",
                normalAttack.getGenericReturnType().getTypeName());
        assertEquals(0,
                normalAttack.getParameterCount());
        assertTrue(Modifier.isPublic(normalAttack.getModifiers()));
    }

    @Test
    public void testFullMoonPikeOverrideChargedAttackMethod() throws Exception {
        Method chargedAttack = fullMoonPikeClass.getDeclaredMethod("chargedAttack");

        assertEquals("java.lang.String",
                chargedAttack.getGenericReturnType().getTypeName());
        assertEquals(0,
                chargedAttack.getParameterCount());
        assertTrue(Modifier.isPublic(chargedAttack.getModifiers()));
    }

    @Test
    public void testFullMoonPikeOverrideGetNameMethod() throws Exception {
        Method getName = fullMoonPikeClass.getDeclaredMethod("getName");

        assertEquals("java.lang.String",
                getName.getGenericReturnType().getTypeName());
        assertEquals(0,
                getName.getParameterCount());
        assertTrue(Modifier.isPublic(getName.getModifiers()));
    }

    @Test
    public void testFullMoonPikeOverrideGetHolderMethod() throws Exception {
        Method getHolderName = fullMoonPikeClass.getDeclaredMethod("getHolderName");

        assertEquals("java.lang.String",
                getHolderName.getGenericReturnType().getTypeName());
        assertEquals(0,
                getHolderName.getParameterCount());
        assertTrue(Modifier.isPublic(getHolderName.getModifiers()));
    }

    // TODO: buat test untuk menguji hasil dari pemanggilan method
}

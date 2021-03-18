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
public class SeawardPrideTest {
    private Class<?> seawardPrideClass;

    @BeforeEach
    public void setUp() throws Exception {
        seawardPrideClass = Class.forName("id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.SeawardPride");
    }

    @Test
    public void testSeawardPrideIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(seawardPrideClass.getModifiers()));
    }

    @Test
    public void testSeawardPrideIsAWeapon() {
        Collection<Type> interfaces = Arrays.asList(seawardPrideClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.Weapon")));
    }

    @Test
    public void testSeawardPrideOverrideNormalAttackMethod() throws Exception {
        Method normalAttack = seawardPrideClass.getDeclaredMethod("normalAttack");

        assertEquals("java.lang.String",
                normalAttack.getGenericReturnType().getTypeName());
        assertEquals(0,
                normalAttack.getParameterCount());
        assertTrue(Modifier.isPublic(normalAttack.getModifiers()));
    }

    @Test
    public void testSeawardPrideOverrideChargedAttackMethod() throws Exception {
        Method chargedAttack = seawardPrideClass.getDeclaredMethod("chargedAttack");

        assertEquals("java.lang.String",
                chargedAttack.getGenericReturnType().getTypeName());
        assertEquals(0,
                chargedAttack.getParameterCount());
        assertTrue(Modifier.isPublic(chargedAttack.getModifiers()));
    }

    @Test
    public void testSeawardPrideOverrideGetNameMethod() throws Exception {
        Method getName = seawardPrideClass.getDeclaredMethod("getName");

        assertEquals("java.lang.String",
                getName.getGenericReturnType().getTypeName());
        assertEquals(0,
                getName.getParameterCount());
        assertTrue(Modifier.isPublic(getName.getModifiers()));
    }

    @Test
    public void testSeawardPrideOverrideGetHolderMethod() throws Exception {
        Method getHolderName = seawardPrideClass.getDeclaredMethod("getHolderName");

        assertEquals("java.lang.String",
                getHolderName.getGenericReturnType().getTypeName());
        assertEquals(0,
                getHolderName.getParameterCount());
        assertTrue(Modifier.isPublic(getHolderName.getModifiers()));
    }

    // TODO: buat test untuk menguji hasil dari pemanggilan method
}

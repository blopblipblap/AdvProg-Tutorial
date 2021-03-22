package id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

// TODO: add tests
public class FesteringGreedTest {
    private Class<?> festeringGreedClass;

    @BeforeEach
    public void setUp() throws Exception {
        festeringGreedClass = Class.forName("id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.FesteringGreed");
    }

    @Test
    public void testFesteringGreedIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(festeringGreedClass.getModifiers()));
    }

    @Test
    public void testFesteringGreedIsAWeapon() {
        Collection<Type> interfaces = Arrays.asList(festeringGreedClass.getInterfaces());
        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.Weapon")));
    }

    @Test
    public void testFesteringGreedOverrideNormalAttackMethod() throws Exception {
        Method normalAttack = festeringGreedClass.getDeclaredMethod("normalAttack");

        assertEquals("java.lang.String",
                normalAttack.getGenericReturnType().getTypeName());
        assertEquals(0,
                normalAttack.getParameterCount());
        assertTrue(Modifier.isPublic(normalAttack.getModifiers()));
    }

    @Test
    public void testFesteringGreedOverrideChargedAttackMethod() throws Exception {
        Method chargedAttack = festeringGreedClass.getDeclaredMethod("chargedAttack");

        assertEquals("java.lang.String",
                chargedAttack.getGenericReturnType().getTypeName());
        assertEquals(0,
                chargedAttack.getParameterCount());
        assertTrue(Modifier.isPublic(chargedAttack.getModifiers()));
    }

    @Test
    public void testFesteringGreedOverrideGetNameMethod() throws Exception {
        Method getName = festeringGreedClass.getDeclaredMethod("getName");

        assertEquals("java.lang.String",
                getName.getGenericReturnType().getTypeName());
        assertEquals(0,
                getName.getParameterCount());
        assertTrue(Modifier.isPublic(getName.getModifiers()));
    }

    @Test
    public void testFesteringGreedOverrideGetHolderMethod() throws Exception {
        Method getHolderName = festeringGreedClass.getDeclaredMethod("getHolderName");

        assertEquals("java.lang.String",
                getHolderName.getGenericReturnType().getTypeName());
        assertEquals(0,
                getHolderName.getParameterCount());
        assertTrue(Modifier.isPublic(getHolderName.getModifiers()));
    }

    // TODO: buat test untuk menguji hasil dari pemanggilan method
    @Test
    public void testFesteringGreedNormalAttackReturnValue() throws Exception {
        Weapon mockFestering = new FesteringGreed("Albedo");

        String normalAttack = mockFestering.normalAttack();

        assertThat(normalAttack).isEqualTo("Enemy is hurt");
    }

    @Test
    public void testFesteringGreedChargedAttackReturnValue() throws Exception {
        Weapon mockFestering = new FesteringGreed("Albedo");

        String chargedAttack = mockFestering.chargedAttack();

        assertThat(chargedAttack).isEqualTo("HIYAAA!!");
    }

    @Test
    public void testFesteringGreedGetNameReturnValue() throws Exception {
        Weapon mockFestering = new FesteringGreed("Albedo");

        String weapName = mockFestering.getName();

        assertThat(weapName).isEqualTo("Festering Greed");
    }

    @Test
    public void testFesteringGreedGetHolderReturnValue() throws Exception {
        Weapon mockFestering = new FesteringGreed("Albedo");

        String holderName = mockFestering.getHolderName();

        assertThat(holderName).isEqualTo("Albedo");
    }
}

package id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// TODO: add tests
public class WeaponTest {
    private Class<?> weaponClass;

    @BeforeEach
    public void setup() throws Exception {
        weaponClass = Class.forName("id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.Weapon");
    }

    @Test
    public void testWeaponIsAPublicInterface() {
        int classModifiers = weaponClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));
        assertTrue(Modifier.isInterface(classModifiers));
    }

    @Test
    public void testWeaponHasNormalAttackAbstractMethod() throws Exception {
        Method normalAttack = weaponClass.getDeclaredMethod("normalAttack");
        int methodModifiers = normalAttack.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, normalAttack.getParameterCount());
    }

    @Test
    public void testWeaponHasChargedAttackAbstractMethod() throws Exception {
        Method chargedAttack = weaponClass.getDeclaredMethod("chargedAttack");
        int methodModifiers = chargedAttack.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, chargedAttack.getParameterCount());
    }

    @Test
    public void testWeaponHasGetNameAbstractMethod() throws Exception {
        Method getName = weaponClass.getDeclaredMethod("getName");
        int methodModifiers = getName.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, getName.getParameterCount());
    }

    @Test
    public void testWeaponHasGetHolderNameAbstractMethod() throws Exception {
        Method getHolderName = weaponClass.getDeclaredMethod("getHolderName");
        int methodModifiers = getHolderName.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, getHolderName.getParameterCount());
    }
}

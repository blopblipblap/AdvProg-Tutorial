package id.ac.ui.cs.advprog.tutorial3.adapter.core.weaponadapters;

import id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.Spellbook;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.TheWindjedi;
import id.ac.ui.cs.advprog.tutorial3.facade.core.misc.Spell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

// TODO: add tests
public class SpellbookAdapterTest {
    private Class<?> spellbookAdapterClass;
    private Class<?> spellbookClass;

    @BeforeEach
    public void setUp() throws Exception {
        spellbookAdapterClass = Class.forName("id.ac.ui.cs.advprog.tutorial3.adapter.core.weaponadapters.SpellbookAdapter");
        spellbookClass = Class.forName("id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.Spellbook");
    }

    @Test
    public void testSpellbookAdapterIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(spellbookAdapterClass.getModifiers()));
    }

    @Test
    public void testSpellbookAdapterIsAWeapon() {
        Collection<Type> interfaces = Arrays.asList(spellbookAdapterClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.Weapon")));
    }

    @Test
    public void testSpellbookAdapterConstructorReceivesSpellbookAsParameter() {
        Class<?>[] classArg = new Class[1];
        classArg[0] = spellbookClass;
        Collection<Constructor<?>> constructors = Arrays.asList(
                spellbookAdapterClass.getDeclaredConstructors());

        assertTrue(constructors.stream()
                .anyMatch(type -> Arrays.equals(
                        type.getParameterTypes(), classArg)));
    }

    @Test
    public void testSpellbookAdapterOverrideNormalAttackMethod() throws Exception {
        Method normalAttack = spellbookAdapterClass.getDeclaredMethod("normalAttack");

        assertEquals("java.lang.String",
                normalAttack.getGenericReturnType().getTypeName());
        assertEquals(0,
                normalAttack.getParameterCount());
        assertTrue(Modifier.isPublic(normalAttack.getModifiers()));
    }

    @Test
    public void testSpellbookAdapterOverrideChargedAttackMethod() throws Exception {
        Method chargedAttack = spellbookAdapterClass.getDeclaredMethod("chargedAttack");

        assertEquals("java.lang.String",
                chargedAttack.getGenericReturnType().getTypeName());
        assertEquals(0,
                chargedAttack.getParameterCount());
        assertTrue(Modifier.isPublic(chargedAttack.getModifiers()));
    }

    @Test
    public void testSpellbookAdapterOverrideGetNameMethod() throws Exception {
        Method getName = spellbookAdapterClass.getDeclaredMethod("getName");

        assertEquals("java.lang.String",
                getName.getGenericReturnType().getTypeName());
        assertEquals(0,
                getName.getParameterCount());
        assertTrue(Modifier.isPublic(getName.getModifiers()));
    }

    @Test
    public void testSpellbookAdapterOverrideGetHolderMethod() throws Exception {
        Method getHolderName = spellbookAdapterClass.getDeclaredMethod("getHolderName");

        assertEquals("java.lang.String",
                getHolderName.getGenericReturnType().getTypeName());
        assertEquals(0,
                getHolderName.getParameterCount());
        assertTrue(Modifier.isPublic(getHolderName.getModifiers()));
    }

    // TODO: buat test untuk menguji hasil dari pemanggilan method
    @Test
    public void testSpellbookAdapterNormalAttackShouldBeSmallSpell() throws Exception {
        Spellbook mockSpellbook = new TheWindjedi("Barbara");
        SpellbookAdapter spellbookAdapter = new SpellbookAdapter(mockSpellbook);

        assertEquals(mockSpellbook.smallSpell(),
                spellbookAdapter.normalAttack());
    }

    @Test
    public void testSpellbookAdapterChargedAttackShouldBeLargeSpell() throws Exception {
        Spellbook mockSpellbook = new TheWindjedi("Barbara");
        SpellbookAdapter spellbookAdapter = new SpellbookAdapter(mockSpellbook);

        assertEquals(mockSpellbook.largeSpell(),
                spellbookAdapter.chargedAttack());
    }

    @Test
    public void testSpellbookAdapterCannotDoLargeSpellTwoTimesInARow() throws Exception {
        Spellbook mockSpellbook = new TheWindjedi("Barbara");
        SpellbookAdapter spellbookAdapter = new SpellbookAdapter(mockSpellbook);

        assertEquals(mockSpellbook.largeSpell(),
                spellbookAdapter.chargedAttack());
        assertEquals("Magic power not enough for large spell",
                spellbookAdapter.chargedAttack());
    }

    @Test
    public void testSpellbookAdapterGetNameReturnValue() throws Exception {
        Spellbook mockSpellbook = new TheWindjedi("Barbara");
        SpellbookAdapter spellbookAdapter = new SpellbookAdapter(mockSpellbook);

        assertEquals(mockSpellbook.getName(),
                spellbookAdapter.getName());
    }

    @Test
    public void testSpellbookAdapterGetHolderReturnValue() throws Exception {
        Spellbook mockSpellbook = new TheWindjedi("Barbara");
        SpellbookAdapter spellbookAdapter = new SpellbookAdapter(mockSpellbook);

        assertEquals(mockSpellbook.getHolderName(),
                spellbookAdapter.getHolderName());
    }
}

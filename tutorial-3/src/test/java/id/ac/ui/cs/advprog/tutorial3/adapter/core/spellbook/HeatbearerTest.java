package id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook;

import id.ac.ui.cs.advprog.tutorial3.facade.core.misc.Spell;
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
public class HeatbearerTest {
    private Class<?> heatbearerClass;

    @BeforeEach
    public void setUp() throws Exception {
        heatbearerClass = Class.forName("id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.Heatbearer");
    }

    @Test
    public void testHeatbearerIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(heatbearerClass.getModifiers()));
    }

    @Test
    public void testHeatbearerIsASpellbook() {
        Collection<Type> interfaces = Arrays.asList(heatbearerClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.Spellbook")));
    }

    @Test
    public void testHeatbearerOverrideSmallSpellMethod() throws Exception {
        Method smallSpell = heatbearerClass.getDeclaredMethod("smallSpell");

        assertEquals("java.lang.String",
                smallSpell.getGenericReturnType().getTypeName());
        assertEquals(0,
                smallSpell.getParameterCount());
        assertTrue(Modifier.isPublic(smallSpell.getModifiers()));
    }

    @Test
    public void testHeatbearerOverrideLargeSpellMethod() throws Exception {
        Method largeSpell = heatbearerClass.getDeclaredMethod("largeSpell");

        assertEquals("java.lang.String",
                largeSpell.getGenericReturnType().getTypeName());
        assertEquals(0,
                largeSpell.getParameterCount());
        assertTrue(Modifier.isPublic(largeSpell.getModifiers()));
    }

    @Test
    public void testHeatbearerOverrideGetNameMethod() throws Exception {
        Method getName = heatbearerClass.getDeclaredMethod("getName");

        assertEquals("java.lang.String",
                getName.getGenericReturnType().getTypeName());
        assertEquals(0,
                getName.getParameterCount());
        assertTrue(Modifier.isPublic(getName.getModifiers()));
    }

    @Test
    public void testHeatbearerOverrideGetHolderMethod() throws Exception {
        Method getHolderName = heatbearerClass.getDeclaredMethod("getHolderName");

        assertEquals("java.lang.String",
                getHolderName.getGenericReturnType().getTypeName());
        assertEquals(0,
                getHolderName.getParameterCount());
        assertTrue(Modifier.isPublic(getHolderName.getModifiers()));
    }

    // TODO: buat test untuk menguji hasil dari pemanggilan method
    @Test
    public void testHeatbearerSmallSpellReturnValue() throws Exception {
        Spellbook mockHeatbearer = new Heatbearer("Lisa");

        String smallSpell = mockHeatbearer.smallSpell();

        assertThat(smallSpell).isEqualTo("Enemy scarred");
    }

    @Test
    public void testHeatbearerLargeSpellReturnValue() throws Exception {
        Spellbook mockHeatbearer = new Heatbearer("Lisa");

        String largeSpell = mockHeatbearer.largeSpell();

        assertThat(largeSpell).isEqualTo("EXPUULOOOOSHHHIOONNNN!");
    }

    @Test
    public void testHeatbearerGetNameReturnValue() throws Exception {
        Spellbook mockHeatbearer = new Heatbearer("Lisa");

        String weapName = mockHeatbearer.getName();

        assertThat(weapName).isEqualTo("Heat Bearer");
    }

    @Test
    public void testHeatbearerGetHolderReturnValue() throws Exception {
        Spellbook mockHeatbearer = new Heatbearer("Lisa");

        String holderName = mockHeatbearer.getHolderName();

        assertThat(holderName).isEqualTo("Lisa");
    }
}

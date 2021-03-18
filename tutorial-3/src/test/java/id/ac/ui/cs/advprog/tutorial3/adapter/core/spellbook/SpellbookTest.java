package id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// TODO: add tests
public class SpellbookTest {
    private Class<?> spellbookClass;

    @BeforeEach
    public void setup() throws Exception {
        spellbookClass = Class.forName("id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.Spellbook");
    }

    @Test
    public void testSpellbookIsAPublicInterface() {
        int classModifiers = spellbookClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));
        assertTrue(Modifier.isInterface(classModifiers));
    }

    @Test
    public void testSpellbookHasSmallSpellAbstractMethod() throws Exception {
        Method smallSpell = spellbookClass.getDeclaredMethod("smallSpell");
        int methodModifiers = smallSpell.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, smallSpell.getParameterCount());
    }

    @Test
    public void testSpellbookHasLargeSpellAbstractMethod() throws Exception {
        Method largeSpell = spellbookClass.getDeclaredMethod("largeSpell");
        int methodModifiers = largeSpell.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, largeSpell.getParameterCount());
    }

    @Test
    public void testSpellbookHasGetNameAbstractMethod() throws Exception {
        Method getName = spellbookClass.getDeclaredMethod("getName");
        int methodModifiers = getName.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, getName.getParameterCount());
    }

    @Test
    public void testSpellbookHasGetHolderNameAbstractMethod() throws Exception {
        Method getHolderName = spellbookClass.getDeclaredMethod("getHolderName");
        int methodModifiers = getHolderName.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, getHolderName.getParameterCount());
    }
}

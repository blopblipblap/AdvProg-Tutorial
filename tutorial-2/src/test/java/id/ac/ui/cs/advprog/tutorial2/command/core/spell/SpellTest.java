package id.ac.ui.cs.advprog.tutorial2.command.core.spell;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpellTest {

    private Class<?> spellClass;

    @BeforeEach
    public void setup() throws Exception {
        spellClass = Class.forName("id.ac.ui.cs.advprog.tutorial2.command.core.spell.Spell");
    }

    @Test
    public void testSpellIsAPublicInterface() {
        int classModifiers = spellClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));
        assertTrue(Modifier.isInterface(classModifiers));
    }

    @Test
    public void testSpellHasCastAbstractMethod() throws Exception {
        Method cast = spellClass.getDeclaredMethod("cast");
        int methodModifiers = cast.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, cast.getParameterCount());
    }

    @Test
    public void testSpellHasUndoAbstractMethod() throws Exception {
        Method undo = spellClass.getDeclaredMethod("undo");
        int methodModifiers = undo.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, undo.getParameterCount());
    }

    @Test
    public void testSpellHasSpellNameAbstractMethod() throws Exception {
        Method spellName = spellClass.getDeclaredMethod("undo");
        int methodModifiers = spellName.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, spellName.getParameterCount());
    }
}

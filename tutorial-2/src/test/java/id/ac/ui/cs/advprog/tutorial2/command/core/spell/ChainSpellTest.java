package id.ac.ui.cs.advprog.tutorial2.command.core.spell;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class ChainSpellTest {

    private Class<?> chainSpellClass;

    @BeforeEach
    public void setUp() throws Exception {
        chainSpellClass = Class.forName("id.ac.ui.cs.advprog.tutorial2.command.core.spell.ChainSpell");
    }

    @Test
    public void testChainSpellIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(chainSpellClass.getModifiers()));
    }

    @Test
    public void testChainSpellIsASpell() {
        Collection<Type> interfaces = Arrays.asList(chainSpellClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial2.command.core.spell.Spell")));
    }

    @Test
    public void testChainSpellOverrideSpellNameMethod() throws Exception {
        Method spellName = chainSpellClass.getDeclaredMethod("spellName");

        assertEquals("java.lang.String", spellName.getGenericReturnType().getTypeName());
        assertEquals(0, spellName.getParameterCount());
    }

    @Test
    public void testChainSpellOverrideCastMethod() throws Exception {
        Method cast = chainSpellClass.getDeclaredMethod("cast");

        assertTrue(Modifier.isPublic(cast.getModifiers()));
    }

    @Test
    public void testChainSpellOverrideUndoMethod() throws Exception {
        Method undo = chainSpellClass.getDeclaredMethod("undo");
        assertTrue(Modifier.isPublic(undo.getModifiers()));
    }
}

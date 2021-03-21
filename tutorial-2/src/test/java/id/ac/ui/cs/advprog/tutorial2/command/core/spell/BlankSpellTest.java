package id.ac.ui.cs.advprog.tutorial2.command.core.spell;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BlankSpellTest {

    private Class<?> blankSpellClass;

    @BeforeEach
    public void setUp() throws Exception {
        blankSpellClass = Class.forName("id.ac.ui.cs.advprog.tutorial2.command.core.spell.BlankSpell");
    }

    @Test
    public void testBlankSpellIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(blankSpellClass.getModifiers()));
    }

    @Test
    public void testBlankSpellIsASpell() {
        Collection<Type> interfaces = Arrays.asList(blankSpellClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial2.command.core.spell.Spell")));
    }

    @Test
    public void testBlankSpellOverrideSpellNameMethod() throws Exception {
        Method spellName = blankSpellClass.getDeclaredMethod("spellName");

        assertEquals("java.lang.String",
                spellName.getGenericReturnType().getTypeName());
        assertEquals(0,
                spellName.getParameterCount());
    }

    @Test
    public void testBlankSpellOverrideCastMethod() throws Exception {
        Method undo = blankSpellClass.getDeclaredMethod("cast");
        BlankSpell blankSpell = spy(BlankSpell.class);

        doNothing().when(blankSpell).cast();
        blankSpell.cast();

        verify(blankSpell, times(1)).cast();
        assertTrue(Modifier.isPublic(undo.getModifiers()));
    }

    @Test
    public void testBlankSpellOverrideUndoMethod() throws Exception {
        Method undo = blankSpellClass.getDeclaredMethod("undo");
        BlankSpell blankSpell = new BlankSpell();
        BlankSpell blankSpell1Spy = spy(blankSpell);

        doNothing().when(blankSpell1Spy).undo();
        blankSpell1Spy.undo();

        verify(blankSpell1Spy, times(1)).undo();
        assertTrue(Modifier.isPublic(undo.getModifiers()));
    }
}

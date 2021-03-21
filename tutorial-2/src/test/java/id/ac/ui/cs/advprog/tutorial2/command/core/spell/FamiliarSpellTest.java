package id.ac.ui.cs.advprog.tutorial2.command.core.spell;

import id.ac.ui.cs.advprog.tutorial2.command.core.spirit.Familiar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FamiliarSpellTest {

    private Class<?> familiarSpellClass;

    @Mock
    private Familiar familiar;

    @BeforeEach
    public void setUp() throws Exception {
        familiarSpellClass = Class.forName("id.ac.ui.cs.advprog.tutorial2.command.core.spell.FamiliarSpell");
    }

    @Test
    public void testFamiliarSpellIsAbstractClass() {
        assertTrue(Modifier.isAbstract(familiarSpellClass.getModifiers()));
    }

    @Test
    public void testFamiliarSpellOverrideUndoMethod() throws Exception {
        Method undo = familiarSpellClass.getDeclaredMethod("undo");

        assertTrue(Modifier.isPublic(undo.getModifiers()));
        assertEquals(0, undo.getParameterCount());
    }
}

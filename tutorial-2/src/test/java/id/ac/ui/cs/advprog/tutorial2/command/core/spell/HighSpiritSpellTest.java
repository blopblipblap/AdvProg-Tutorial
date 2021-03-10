package id.ac.ui.cs.advprog.tutorial2.command.core.spell;

import id.ac.ui.cs.advprog.tutorial2.command.core.spirit.HighSpirit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HighSpiritSpellTest {

    private Class<?> highSpiritSpellClass;

    @Mock
    private HighSpirit highSpirit;

    @BeforeEach
    public void setUp() throws Exception {
        highSpiritSpellClass = Class.forName("id.ac.ui.cs.advprog.tutorial2.command.core.spell.HighSpiritSpell");
    }

    @Test
    public void testHighSpiritSpellIsAbstractClass() {
        assertTrue(Modifier.isAbstract(highSpiritSpellClass.getModifiers()));
    }

    @Test
    public void testHighSpiritSpellOverrideUndoMethod() throws Exception {
        Method undo = highSpiritSpellClass.getDeclaredMethod("undo");

        assertTrue(Modifier.isPublic(undo.getModifiers()));
        assertEquals(0, undo.getParameterCount());
    }
}

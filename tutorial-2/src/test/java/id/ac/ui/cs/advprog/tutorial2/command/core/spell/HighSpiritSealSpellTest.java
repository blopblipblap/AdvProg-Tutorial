package id.ac.ui.cs.advprog.tutorial2.command.core.spell;

import id.ac.ui.cs.advprog.tutorial2.command.core.spirit.HighSpirit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

public class HighSpiritSealSpellTest {

    private Class<?> highSpiritSealSpellClass;

    private HighSpiritSealSpell highSpiritSealSpell;

    @Mock
    private HighSpirit highSpirit;

    @BeforeEach
    public void setUp() throws Exception {
        highSpiritSealSpellClass = Class.forName("id.ac.ui.cs.advprog.tutorial2.command.core.spell.HighSpiritSealSpell");
        highSpirit = mock(HighSpirit.class);
        highSpiritSealSpell = new HighSpiritSealSpell(highSpirit);
    }

    @Test
    public void testHighSpiritSealSpellIsConcreteClass() {
        assertFalse(Modifier.isAbstract(highSpiritSealSpellClass.getModifiers()));
    }

    @Test
    public void testHighSpiritSealSpellSpellNameMethodSpellName() throws Exception {
        Method spellName = highSpiritSealSpellClass.getDeclaredMethod("spellName");

        assertEquals("java.lang.String", spellName.getGenericReturnType().getTypeName());
        assertEquals(0, spellName.getParameterCount());
    }

    @Test
    public void testHighSpiritSealSpellCastMethodItShouldCallHighSpiritSeal() throws Exception {
        Method cast = highSpiritSealSpellClass.getDeclaredMethod("cast");

        assertEquals(0, cast.getParameterCount());
    }

    @Test
    public void testWhenCastedItShouldCallSeal() {
        highSpiritSealSpell.cast();

        verify(highSpirit, times(1)).seal();
    }
}

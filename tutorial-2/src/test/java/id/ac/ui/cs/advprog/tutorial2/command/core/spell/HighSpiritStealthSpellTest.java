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

public class  HighSpiritStealthSpellTest{

    private Class<?> highSpiritStealthSpellClass;

    private HighSpiritStealthSpell highSpiritStealthSpell;

    @Mock
    private HighSpirit highSpirit;

    @BeforeEach
    public void setUp() throws Exception {
        highSpiritStealthSpellClass = Class.forName("id.ac.ui.cs.advprog.tutorial2.command.core.spell.FamiliarSealSpell");
        highSpirit = mock(HighSpirit.class);
        highSpiritStealthSpell = new HighSpiritStealthSpell(highSpirit);
    }

    @Test
    public void testHighSpiritStealthSpellIsConcreteClass() {
        assertFalse(Modifier.isAbstract(highSpiritStealthSpellClass.getModifiers()));
    }

    @Test
    public void testHighSpiritStealthSpellSpellNameMethodSpellName() throws Exception {
        Method spellName = highSpiritStealthSpellClass.getDeclaredMethod("spellName");

        highSpiritStealthSpell.spellName();

        verify(highSpirit, times(1)).getRace();

        assertEquals("java.lang.String", spellName.getGenericReturnType().getTypeName());
        assertEquals(0, spellName.getParameterCount());
    }

    @Test
    public void testHighSpiritStealthSpellTestCastMethodItShouldCallFamiliarSeal() throws Exception {
        Method cast = highSpiritStealthSpellClass.getDeclaredMethod("cast");

        assertEquals(0, cast.getParameterCount());
    }

    @Test
    public void testWhenCastedItShouldCallStealthStance() {
        highSpiritStealthSpell.cast();

        verify(highSpirit, times(1)).stealthStance();
    }
}

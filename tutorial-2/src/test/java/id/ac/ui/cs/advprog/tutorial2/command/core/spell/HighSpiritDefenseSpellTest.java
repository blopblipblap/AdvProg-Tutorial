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

public class  HighSpiritDefenseSpellTest{

    private Class<?> highSpiritDefenseSpellClass;

    private HighSpiritDefenseSpell highSpiritDefenseSpell;

    @Mock
    private HighSpirit highSpirit;

    @BeforeEach
    public void setUp() throws Exception {
        highSpiritDefenseSpellClass = Class.forName("id.ac.ui.cs.advprog.tutorial2.command.core.spell.FamiliarSealSpell");
        highSpirit = mock(HighSpirit.class);
        highSpiritDefenseSpell = new HighSpiritDefenseSpell(highSpirit);
    }

    @Test
    public void testHighSpiritDefenseSpellIsConcreteClass() {
        assertFalse(Modifier.isAbstract(highSpiritDefenseSpellClass.getModifiers()));
    }

    @Test
    public void testHighSpiritDefenseSpellSpellNameMethodSpellName() throws Exception {
        Method spellName = highSpiritDefenseSpellClass.getDeclaredMethod("spellName");

        highSpiritDefenseSpell.spellName();

        verify(highSpirit, times(1)).getRace();

        assertEquals("java.lang.String", spellName.getGenericReturnType().getTypeName());
        assertEquals(0, spellName.getParameterCount());
    }

    @Test
    public void testHighSpiritDefenseSpellTestCastMethodItShouldCallFamiliarSeal() throws Exception {
        Method cast = highSpiritDefenseSpellClass.getDeclaredMethod("cast");

        assertEquals(0, cast.getParameterCount());
    }

    @Test
    public void testWhenCastedItShouldDefenseStance() {
        highSpiritDefenseSpell.cast();

        verify(highSpirit, times(1)).defenseStance();
    }
}

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

public class  HighSpiritAttackSpellTest{

    private Class<?> highSpiritAttackSpellClass;

    private HighSpiritAttackSpell highSpiritAttackSpell;

    @Mock
    private HighSpirit highSpirit;

    @BeforeEach
    public void setUp() throws Exception {
        highSpiritAttackSpellClass = Class.forName("id.ac.ui.cs.advprog.tutorial2.command.core.spell.FamiliarSealSpell");
        highSpirit = mock(HighSpirit.class);
        highSpiritAttackSpell = new HighSpiritAttackSpell(highSpirit);
    }

    @Test
    public void testHighSpiritAttackSpellIsConcreteClass() {
        assertFalse(Modifier.isAbstract(highSpiritAttackSpellClass.getModifiers()));
    }

    @Test
    public void testHighSpiritAttackSpellSpellNameMethodSpellName() throws Exception {
        Method spellName = highSpiritAttackSpellClass.getDeclaredMethod("spellName");

        highSpiritAttackSpell.spellName();

        verify(highSpirit, times(1)).getRace();

        assertEquals("java.lang.String", spellName.getGenericReturnType().getTypeName());
        assertEquals(0, spellName.getParameterCount());
    }

    @Test
    public void testHighSpiritAttackSpellTestCastMethodItShouldCallFamiliarSeal() throws Exception {
        Method cast = highSpiritAttackSpellClass.getDeclaredMethod("cast");

        assertEquals(0, cast.getParameterCount());
    }

    @Test
    public void testWhenCastedItShouldCallAttackStance() {
        highSpiritAttackSpell.cast();

        verify(highSpirit, times(1)).attackStance();
    }
}

package id.ac.ui.cs.advprog.tutorial2.command.core.spell;

import id.ac.ui.cs.advprog.tutorial2.command.core.spirit.Familiar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

public class FamiliarSealSpellTest {

    private Class<?> familiarSealSpellClass;

    private FamiliarSealSpell familiarSealSpell;

    @Mock
    private Familiar familiar;

    @BeforeEach
    public void setUp() throws Exception {
        familiarSealSpellClass = Class.forName("id.ac.ui.cs.advprog.tutorial2.command.core.spell.FamiliarSealSpell");
        familiar = mock(Familiar.class);
        familiarSealSpell = new FamiliarSealSpell(familiar);
    }

    @Test
    public void testFamiliarSealSpellIsConcreteClass() {
        assertFalse(Modifier.isAbstract(familiarSealSpellClass.getModifiers()));
    }

    @Test
    public void testFamiliarSealSpellSpellNameMethodSpellName() throws Exception {
        Method spellName = familiarSealSpellClass.getDeclaredMethod("spellName");

        assertEquals("java.lang.String", spellName.getGenericReturnType().getTypeName());
        assertEquals(0, spellName.getParameterCount());
    }

    @Test
    public void testFamiliarSealSpellCastMethodItShouldCallFamiliarSeal() throws Exception {
        Method cast = familiarSealSpellClass.getDeclaredMethod("cast");

        assertEquals(0, cast.getParameterCount());
    }

    @Test
    public void testWhenCastedItShouldCallSeal() {
        familiarSealSpell.cast();

        verify(familiar, times(1)).seal();
    }
}

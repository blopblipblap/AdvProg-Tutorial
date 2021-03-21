package id.ac.ui.cs.advprog.tutorial2.command.core.spell;

import id.ac.ui.cs.advprog.tutorial2.command.core.spirit.Familiar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

public class FamiliarSummonSpellTest {

    private Class<?> familiarSummonSpellClass;


    @BeforeEach
    public void setUp() throws Exception {
        familiarSummonSpellClass = Class.forName("id.ac.ui.cs.advprog.tutorial2.command.core.spell.FamiliarSummonSpell");
    }

    @Test
    public void familiarSummonSpellIsConcreteClass() {
        assertFalse(Modifier.isAbstract(familiarSummonSpellClass.getModifiers()));
    }

    @Test
    public void familiarSummonSpellCastMethodFamiliarShoulCallSummon() throws Exception {
        Familiar familar = mock(Familiar.class);
        FamiliarSummonSpell familiarSummonSpell = new FamiliarSummonSpell(familar);

        familiarSummonSpell.cast();
        verify(familar, times(1)).summon();
    }

    @Test
    public void familiarSummonSpellSpellNameShoulReturnSpellName() throws Exception {
        Method spellName = familiarSummonSpellClass.getDeclaredMethod("spellName");

        assertEquals("java.lang.String",
                spellName.getGenericReturnType().getTypeName());
        assertEquals(0,
                spellName.getParameterCount());
    }
}

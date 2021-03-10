package id.ac.ui.cs.advprog.tutorial2.command.repository;

import id.ac.ui.cs.advprog.tutorial2.command.core.spell.BlankSpell;
import id.ac.ui.cs.advprog.tutorial2.command.core.spell.Spell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ContractSealTest {

    private ContractSeal contractSeal;

    @BeforeEach
    public void setUp() {
        contractSeal = new ContractSeal();
    }

    @Test
    public void testRegisterSpellShouldAddItToTheRepository() {
        Spell newSpell = new BlankSpell();

        contractSeal.registerSpell(newSpell);
        Collection<Spell> repositorySpell = contractSeal.getSpells();

        assertThat(repositorySpell).hasSize(1);
        assertThat(repositorySpell).contains(newSpell);
    }

    @Test
    public void testCastSpellShouldBeCastedFromRepository() {
        BlankSpell mockedSpell = mock(BlankSpell.class);

        contractSeal.registerSpell(mockedSpell);
        contractSeal.castSpell(mockedSpell.spellName());

        verify(mockedSpell).cast();
    }

    @Test
    public void testUndoSpellShouldBeUndoneFromRepository() {
        BlankSpell mockedSpell = mock(BlankSpell.class);
        ReflectionTestUtils.setField(contractSeal,
                "latestSpell", mockedSpell);
        contractSeal.undoSpell();

        verify(mockedSpell, times(1)).undo();

    }
}

package id.ac.ui.cs.advprog.tutorial2.command.service;

import id.ac.ui.cs.advprog.tutorial2.command.core.spell.BlankSpell;
import id.ac.ui.cs.advprog.tutorial2.command.core.spell.Spell;
import id.ac.ui.cs.advprog.tutorial2.command.core.spirit.Familiar;
import id.ac.ui.cs.advprog.tutorial2.command.core.spirit.HighSpirit;
import id.ac.ui.cs.advprog.tutorial2.command.repository.ContractSeal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SealServiceImplTest {

    @Mock
    private ContractSeal contractSeal;

    @InjectMocks
    private SealServiceImpl sealService;

    @Test
    public void whenCastSpellIsCalledItShouldCallContractSealCastSpell() {
        Spell spell = new BlankSpell();

        sealService.castSpell(spell.spellName());

        verify(contractSeal, times(1)).castSpell(spell.spellName());
    }

    @Test
    public void whenUndoSpellIsCalledItShouldCallContractSealUndoSpell() {
        Spell spell = new BlankSpell();

        sealService.castSpell(spell.spellName());
        sealService.undoSpell();

        verify(contractSeal, times(1)).undoSpell();
    }

    @Test
    public void whenGetSpellsIsCalledItShouldCallContractSealGetSpells() {
        List<Spell> spells = new ArrayList<>();
        spells.add(new BlankSpell());
        sealService.getSpells();

        verify(contractSeal, atLeastOnce()).getSpells();

    }

    @Test
    public void whenGetHighSpiritsIsCalledItShouldReturnListOfHighSpirit() {
        List<HighSpirit> highSpiritsList = new ArrayList<>();
        highSpiritsList.add(new HighSpirit());

        SealService sealSpy = spy(sealService);

        when(sealSpy.getHighSpirits())
                .thenReturn(highSpiritsList);

        Iterable<HighSpirit> calledHighSpirits = sealSpy.getHighSpirits();

        assertThat(calledHighSpirits).isEqualTo(highSpiritsList);

    }

    @Test
    public void whenGetFamiliarsIsCalledItShouldReturnListOfFamiliars() {
        List<Familiar> familiarList = new ArrayList<>();
        familiarList.add(new Familiar());

        SealService sealSpy = spy(sealService);

        when(sealSpy.getFamiliar())
                .thenReturn(familiarList);

        Iterable<Familiar> calledFamiliar = sealSpy.getFamiliar();

        assertThat(calledFamiliar).isEqualTo(familiarList);

    }

}

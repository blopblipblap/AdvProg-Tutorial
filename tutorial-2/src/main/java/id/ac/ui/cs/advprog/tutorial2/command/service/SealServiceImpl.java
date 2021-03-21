package id.ac.ui.cs.advprog.tutorial2.command.service;

import id.ac.ui.cs.advprog.tutorial2.command.repository.ContractSeal;
import id.ac.ui.cs.advprog.tutorial2.command.core.spell.*;
import id.ac.ui.cs.advprog.tutorial2.command.core.spirit.Familiar;
import id.ac.ui.cs.advprog.tutorial2.command.core.spirit.HighSpirit;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class SealServiceImpl implements SealService {
    private ContractSeal seal;
    private Map<String, HighSpirit> spirits;
    private Map<String, Familiar> familiars;

    public SealServiceImpl(ContractSeal seal) {
        this.seal = seal;
        familiars = new HashMap<>();
        spirits = new HashMap<>();
        seed();
    }

    private void seed() {
        Familiar imp = new Familiar("Imp");
        familiars.put(imp.getRace(), imp);
        seal.registerSpell(new FamiliarSummonSpell(imp));
        seal.registerSpell(new FamiliarSealSpell(imp));

        HighSpirit youko = new HighSpirit("Youko");
        spirits.put(youko.getRace(), youko);
        seal.registerSpell(new HighSpiritSealSpell(youko));
        seal.registerSpell(new HighSpiritAttackSpell(youko));
        seal.registerSpell(new HighSpiritStealthSpell(youko));

        HighSpirit demon = new HighSpirit("Demon");
        spirits.put(demon.getRace(), demon);
        seal.registerSpell(new HighSpiritSealSpell(demon));
        seal.registerSpell(new HighSpiritAttackSpell(demon));
        seal.registerSpell(new HighSpiritDefenseSpell(demon));

        seal.registerSpell(new ChainSpell(new ArrayList<Spell>(seal.getSpells())));
    }

    @Override
    public void castSpell(String spellName) {
        // Make castSpell
        seal.castSpell(spellName);
    }

    @Override
    public void undoSpell() {
        // Make undoSpell
        seal.undoSpell();
    }

    @Override
    public Iterable<Spell> getSpells() {
        return seal.getSpells();
    }

    @Override
    public Iterable<HighSpirit> getHighSpirits() {
        return spirits.values();
    }

    @Override
    public Iterable<Familiar> getFamiliar() {
        return familiars.values();
    }
}

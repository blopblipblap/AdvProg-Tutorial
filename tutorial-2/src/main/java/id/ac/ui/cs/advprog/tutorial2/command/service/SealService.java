package id.ac.ui.cs.advprog.tutorial2.command.service;

import id.ac.ui.cs.advprog.tutorial2.command.core.spell.Spell;
import id.ac.ui.cs.advprog.tutorial2.command.core.spirit.Familiar;
import id.ac.ui.cs.advprog.tutorial2.command.core.spirit.HighSpirit;

public interface SealService {
    public void castSpell(String spellName);
    public void undoSpell();
    public Iterable<Spell> getSpells();
    public Iterable<HighSpirit> getHighSpirits();
    public Iterable<Familiar> getFamiliar();
}

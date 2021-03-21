package id.ac.ui.cs.advprog.tutorial2.command.core.spell;

import java.util.ArrayList;

public class ChainSpell implements Spell {
    // TODO: Complete Me
    protected ArrayList<Spell> spellArrayList;

    public ChainSpell(ArrayList<Spell> spellArrayList) {
        this.spellArrayList = spellArrayList;
    }

    @Override
    public String spellName() {
        return "ChainSpell";
    }

    @Override
    public void cast() {
        // cast chain spell
        for (int i = 0; i < spellArrayList.size(); i++) {
            Spell spell = spellArrayList.get(i);
            spell.cast();
        }
    }

    @Override
    public void undo() {
        // undo chain spell
        for (int i = 0; i < spellArrayList.size(); i++) {
            Spell spell = spellArrayList.get(i);
            spell.undo();
        }
    }
}

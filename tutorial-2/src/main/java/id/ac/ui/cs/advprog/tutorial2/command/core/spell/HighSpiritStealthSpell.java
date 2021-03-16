package id.ac.ui.cs.advprog.tutorial2.command.core.spell;

import id.ac.ui.cs.advprog.tutorial2.command.core.spirit.HighSpirit;

public class HighSpiritStealthSpell extends HighSpiritSpell {
    // Make constructor

    public HighSpiritStealthSpell(HighSpirit spirit) {
        super(spirit);
    }

    @Override
    public void cast() {
        spirit.stealthStance();
    }

    @Override
    public String spellName() {
        return spirit.getRace() + ":Stealth";
    }
}

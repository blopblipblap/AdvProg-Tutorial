package id.ac.ui.cs.advprog.tutorial2.command.core.spell;

import id.ac.ui.cs.advprog.tutorial2.command.core.spirit.HighSpirit;

public class HighSpiritSealSpell extends HighSpiritSpell {
    // TODO: Complete Me

    public HighSpiritSealSpell(HighSpirit spirit) {
        super(spirit);
    }

    @Override
    public String spellName() {
        return spirit.getRace() + ":Seal";
    }

    @Override
    public void cast() {
        spirit.seal();
    }
}

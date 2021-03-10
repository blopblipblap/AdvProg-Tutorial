package id.ac.ui.cs.advprog.tutorial2.command.core.spell;

import id.ac.ui.cs.advprog.tutorial2.command.core.spirit.HighSpirit;

public class HighSpiritAttackSpell extends HighSpiritSpell {
    // TODO: Complete Me

    public HighSpiritAttackSpell(HighSpirit spirit) {
        super(spirit);
    }

    @Override
    public String spellName() {
        return spirit.getRace() + ":Attack";
    }

    @Override
    public void cast() {
        spirit.attackStance();
    }
}

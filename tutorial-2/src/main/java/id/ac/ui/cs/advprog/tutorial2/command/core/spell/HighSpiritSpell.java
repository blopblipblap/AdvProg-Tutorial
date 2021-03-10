package id.ac.ui.cs.advprog.tutorial2.command.core.spell;

import id.ac.ui.cs.advprog.tutorial2.command.core.spirit.HighSpirit;
import id.ac.ui.cs.advprog.tutorial2.command.core.spirit.HighSpiritState;

public abstract class HighSpiritSpell implements Spell {
	protected HighSpirit spirit;

    public HighSpiritSpell(HighSpirit spirit) {
        // TODO: Complete Me
    }

    @Override
    public void undo() {
        if (spirit.getPrevState() == HighSpiritState.ATTACK) spirit.attackStance();
        // TODO: Complete Me
    }
}

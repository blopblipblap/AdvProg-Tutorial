package id.ac.ui.cs.advprog.tutorial2.command.core.spell;

import id.ac.ui.cs.advprog.tutorial2.command.core.spirit.Familiar;

public abstract class FamiliarSpell implements Spell {
    protected Familiar familiar;
    // TODO: Complete Me

    @Override
    public void undo() {
        if (familiar.getPrevState() == FamiliarState.ACTIVE) familiar.summon();
        // TODO: Complete Me
    }
}

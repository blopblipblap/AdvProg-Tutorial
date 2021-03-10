package id.ac.ui.cs.advprog.tutorial2.command.core.spell;

import id.ac.ui.cs.advprog.tutorial2.command.core.spirit.Familiar;
import id.ac.ui.cs.advprog.tutorial2.command.core.spirit.FamiliarState;

public abstract class FamiliarSpell implements Spell {
    protected Familiar familiar;
    // TODO: Complete Me

    public FamiliarSpell(Familiar familiar) {
        this.familiar = familiar;
    }

    @Override
    public void undo() {
        if (familiar.getPrevState() == FamiliarState.ACTIVE) familiar.summon();
        // TODO: Complete Me
        if (familiar.getPrevState() == FamiliarState.SEALED) familiar.seal();
    }
}

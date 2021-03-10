package id.ac.ui.cs.advprog.tutorial2.command.core.spell;

import id.ac.ui.cs.advprog.tutorial2.command.core.spirit.Familiar;

public class FamiliarSealSpell extends FamiliarSpell {
    // TODO: Complete Me

    public FamiliarSealSpell(Familiar familiar) {
        super(familiar);
    }

    @Override
    public String spellName() {
        return familiar.getRace() + ":Seal";
    }

    @Override
    public void cast() {
        familiar.seal();
    }
}

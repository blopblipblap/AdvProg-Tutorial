package id.ac.ui.cs.advprog.tutorial2.command.core.spell;

public class FamiliarSummonSpell extends FamiliarSpell {
	// TODO: Complete Me

    @Override
    public String spellName() {
        return familiar.getRace() + ":Summon";
    }
}

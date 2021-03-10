package id.ac.ui.cs.advprog.tutorial2.command.core.spell;

public class BlankSpell implements Spell {

    @Override
    public void cast() {
        // cast nothing
    }

    @Override
    public void undo() {
        // undo nothing
    }

    @Override
    public String spellName() {
        return "Blank Spell";
    }

}

package id.ac.ui.cs.advprog.tutorial2.command.core.spell;

public interface Spell {
    public void cast();
    public void undo();
    public String spellName();
}

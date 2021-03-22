package id.ac.ui.cs.advprog.tutorial3.adapter.core.weaponadapters;

import id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.Spellbook;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.Weapon;

// TODO: complete me :)
public class SpellbookAdapter implements Weapon {

    private Spellbook spellbook;
    private int sign = 0;

    public SpellbookAdapter(Spellbook spellbook) {
        this.spellbook = spellbook;
    }

    @Override
    public String normalAttack() {
        return spellbook.smallSpell();
    }

    @Override
    public String chargedAttack() {
        this.sign += 1;
        if (this.sign % 2 == 0) {
            return "Magic power not enough for large spell";
        } else {
            return spellbook.largeSpell();
        }
    }

    @Override
    public String getName() {
        return spellbook.getName();
    }

    @Override
    public String getHolderName() {
        return spellbook.getHolderName();
    }

}

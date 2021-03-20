package id.ac.ui.cs.advprog.tutorial3.adapter.core.weaponadapters;

import id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.Spellbook;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.Weapon;

// TODO: complete me :)
public class SpellbookAdapter implements Weapon {

    private Spellbook spellbook;
    private int sign;

    public SpellbookAdapter(Spellbook spellbook) {
        this.spellbook = spellbook;
    }

    @Override
    public String normalAttack() {
        this.sign = 0;
        return spellbook.smallSpell();
    }

    @Override
    public String chargedAttack() {
        if (this.sign == 1) {
            return "Magic power not enough for large spell";
        } else {
            this.sign = 1;
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

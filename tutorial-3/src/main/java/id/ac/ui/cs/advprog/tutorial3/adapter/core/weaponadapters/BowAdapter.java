package id.ac.ui.cs.advprog.tutorial3.adapter.core.weaponadapters;

import id.ac.ui.cs.advprog.tutorial3.adapter.core.bow.Bow;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.Weapon;

// TODO: complete me :)
public class BowAdapter implements Weapon {

    private Bow bow;
    private boolean isAimShot;

    public BowAdapter(Bow bow) {
        this.bow = bow;
        this.isAimShot = false;
    }

    @Override
    public String normalAttack() {
        return bow.shootArrow(isAimShot);
    }

    @Override
    public String chargedAttack() {
        if (this.isAimShot) {this.isAimShot = false;}
        else {this.isAimShot = true;}
        return bow.shootArrow(isAimShot);
    }

    @Override
    public String getName() {
        return bow.getName();
    }

    @Override
    public String getHolderName() {
        // TODO: complete me
        return bow.getHolderName();
    }
}

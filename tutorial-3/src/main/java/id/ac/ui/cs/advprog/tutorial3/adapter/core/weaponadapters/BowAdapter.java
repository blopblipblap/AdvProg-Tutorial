package id.ac.ui.cs.advprog.tutorial3.adapter.core.weaponadapters;

import id.ac.ui.cs.advprog.tutorial3.adapter.core.bow.Bow;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.Weapon;

// TODO: complete me :)
public class BowAdapter implements Weapon {

    private Bow bow;
    private boolean isAimShot = false;

    public BowAdapter(Bow bow) {
        this.bow = bow;
    }

    @Override
    public String normalAttack() {
        return bow.shootArrow(this.isAimShot);
    }

    @Override
    public String chargedAttack() {
        if (this.isAimShot) {
            this.isAimShot = false;
            return "Leaving aim shot mode";
        }
        else {
            this.isAimShot = true;
            return "Entered aim shot mode";
        }
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

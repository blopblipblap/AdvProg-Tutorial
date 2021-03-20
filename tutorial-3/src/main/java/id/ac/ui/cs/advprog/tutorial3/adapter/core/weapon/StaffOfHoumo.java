package id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon;

public class StaffOfHoumo implements Weapon {

    private String holderName;

    public StaffOfHoumo(String holderName) {
        this.holderName = holderName;
    }

    @Override
    public String normalAttack() {
        // TODO: complete me
        return "Enemy got stabbed";
    }

    @Override
    public String chargedAttack() {
        // TODO: complete me
        return "Lets go lemnistatic v2";
    }

    @Override
    public String getName() {
        return "Staff of Houmo";
    }

    @Override
    public String getHolderName() { return holderName; }
}

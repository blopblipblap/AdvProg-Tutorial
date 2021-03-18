package id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon;

public class FullMoonPike implements Weapon {

    private String holderName;

    public FullMoonPike(String holderName) {
        this.holderName = holderName;
    }

    @Override
    public String normalAttack() {
        // TODO: complete me
        return null;
    }

    @Override
    public String chargedAttack() {
        // TODO: complete me
        return null;
    }

    @Override
    public String getName() {
        return "Full Moon Pike";
    }

    @Override
    public String getHolderName() { return holderName; }
}

package id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon;

public class SeawardPride implements Weapon {


    private String holderName;

    public SeawardPride(String holderName) {
        this.holderName = holderName;
    }

    @Override
    public String normalAttack() {
        // TODO: complete me
        return "Enemy got hit by big weapon";
    }

    @Override
    public String chargedAttack() {
        // TODO: complete me
        return "Lets go spinny spin spin";
    }

    @Override
    public String getName() {
        return "Seaward Pride";
    }

    @Override
    public String getHolderName() { return holderName; }
}

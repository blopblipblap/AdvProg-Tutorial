package id.ac.ui.cs.advprog.tutorial3.adapter.core.bow;

public class IonicBow implements Bow {

    private String holderName;

    public IonicBow(String holderName) {
        this.holderName = holderName;
    }

    @Override
    public String shootArrow(boolean isAimShot) {
        if(isAimShot) {
            return "Arrow reacted with the enemy's protons";
        } else {
            return "Separated one atom from the enemy";
        }
    }

    @Override
    public String getName() {
        return "Ionic Bow";
    }

    @Override
    public String getHolderName() { return holderName; }
}
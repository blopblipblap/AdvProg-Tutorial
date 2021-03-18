package id.ac.ui.cs.advprog.tutorial3.adapter.core.bow;

public class UranosBow implements Bow {

    private String holderName;

    public UranosBow(String holderName) {
        this.holderName = holderName;
    }

    @Override
    public String shootArrow(boolean isAimShot) {
        if(isAimShot) {
            return "Gaining charge... gaining speed... headshot!";
        } else {
            return "headshot!";
        }
    }

    @Override
    public String getName() {
        return "Uranos Bow";
    }

    @Override
    public String getHolderName() { return holderName; }

}
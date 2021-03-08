package id.ac.ui.cs.advprog.tutorial1.strategy.core;

public class AttackWithGun implements AttackBehavior {
    public AttackWithGun(){}

    public String attack() {
        return "jeder, mati lu";
    }

    @Override
    public String getType() {
        return "Gun";
    }
}

package id.ac.ui.cs.advprog.tutorial1.strategy.core;

public class AttackWithMagic implements AttackBehavior {
    public AttackWithMagic(){}

    public String attack() {
        return "simsalabim, mati lu";
    }

    @Override
    public String getType() {
        return "Magic";
    }
}

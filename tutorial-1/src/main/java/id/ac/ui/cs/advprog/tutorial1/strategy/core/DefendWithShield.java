package id.ac.ui.cs.advprog.tutorial1.strategy.core;

public class DefendWithShield implements DefenseBehavior {
    public DefendWithShield(){}

    public String defend() {
        return "tameng ope";
    }

    @Override
    public String getType() {
        return "Shield";
    }
}

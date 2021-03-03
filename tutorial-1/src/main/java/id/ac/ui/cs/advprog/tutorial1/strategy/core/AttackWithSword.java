package id.ac.ui.cs.advprog.tutorial1.strategy.core;

public class AttackWithSword implements AttackBehavior {
    //ToDo: Complete me
    public AttackWithSword(){}

    public String attack() {
        return "shhshs(bunyi pedang), mati lu";
    }

    @Override
    public String getType() {
        return "Sword";
    }
}

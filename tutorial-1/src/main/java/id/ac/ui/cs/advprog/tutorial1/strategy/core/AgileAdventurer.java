package id.ac.ui.cs.advprog.tutorial1.strategy.core;

public class AgileAdventurer extends Adventurer {
    public AgileAdventurer() {
        attackBehavior = new AttackWithGun();
        defenseBehavior = new DefendWithBarrier();
    }

    public String getAlias() {
        return "Agile Adventurer";
    }

}

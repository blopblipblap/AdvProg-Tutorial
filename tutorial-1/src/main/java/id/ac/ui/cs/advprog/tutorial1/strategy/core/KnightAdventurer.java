package id.ac.ui.cs.advprog.tutorial1.strategy.core;

public class KnightAdventurer extends Adventurer {
    //ToDo: Complete me
    public KnightAdventurer() {
        attackBehavior = new AttackWithGun();
        defenseBehavior = new DefendWithBarrier();
    }

    public String getAlias() {
        return "Knight Adventurer";
    }
}

package id.ac.ui.cs.advprog.tutorial1.strategy.core;

public class KnightAdventurer extends Adventurer {
    //ToDo: Complete me
    public KnightAdventurer() {
        attackBehavior = new AttackWithSword();
        defenseBehavior = new DefendWithArmor();
    }

    public String getAlias() {
        return "Knight Adventurer";
    }
}

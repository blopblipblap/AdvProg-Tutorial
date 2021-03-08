package id.ac.ui.cs.advprog.tutorial1.strategy.core;

public class MysticAdventurer extends Adventurer {
    public MysticAdventurer() {
        attackBehavior = new AttackWithMagic();
        defenseBehavior = new DefendWithShield();
    }

    public String getAlias() {
        return "Mystic Adventurer";
    }
}

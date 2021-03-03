package id.ac.ui.cs.advprog.tutorial1.strategy.core;

public class AgileAdventurer extends Adventurer {
    //ToDo: Complete me
    public AgileAdventurer() {
        attackBehavior = new AttackWithSword();
        defenseBehavior = new DefendWithArmor();
    }

    public String getAlias() {
        return "Agile Adventurer";
    }
}

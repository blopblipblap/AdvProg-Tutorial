package id.ac.ui.cs.advprog.tutorial1.strategy.core;

public abstract class Adventurer {

    protected AttackBehavior attackBehavior;
    protected DefenseBehavior defenseBehavior;

    public String attack () {
        return attackBehavior.attack();
    }

    public String defend() {
        return defenseBehavior.defend();
    }

    public Adventurer() {}

    public abstract String getAlias();

    public void setAttackBehavior(AttackBehavior attackBehavior) {
        this.attackBehavior = attackBehavior;
    }

    public AttackBehavior getAttackBehavior() {
        return attackBehavior;
    }

    public void setDefenseBehavior(DefenseBehavior defenseBehavior) {
        this.defenseBehavior = defenseBehavior;
    }

    public DefenseBehavior getDefenseBehavior() {
        return defenseBehavior;
    }
}

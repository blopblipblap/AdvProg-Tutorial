package id.ac.ui.cs.advprog.tutorial1.strategy.repository;

import id.ac.ui.cs.advprog.tutorial1.strategy.core.AttackBehavior;
import id.ac.ui.cs.advprog.tutorial1.strategy.core.DefenseBehavior;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StrategyRepository {

    private Map<String, AttackBehavior> attackBehaviors = new HashMap<>();
    private Map<String, DefenseBehavior> defenseBehaviors = new HashMap<>();

    public Iterable<AttackBehavior> getAttackBehaviors() {
        return attackBehaviors.values();
    }

    public Iterable<DefenseBehavior> getDefenseBehaviors() {
        return defenseBehaviors.values();
    }

    public void addAttackBehavior(AttackBehavior attackBehavior) {
        this.attackBehaviors.put(attackBehavior.getType(), attackBehavior);
    }

    public void addDefenseBehavior(DefenseBehavior defenseBehavior) {
        this.defenseBehaviors.put(defenseBehavior.getType(), defenseBehavior);
    }

    public AttackBehavior getAttackBehaviorByType(String type) {
        return attackBehaviors.get(type);
    }

    public DefenseBehavior getDefenseBehaviorByType(String type) {
        return defenseBehaviors.get(type);
    }
}

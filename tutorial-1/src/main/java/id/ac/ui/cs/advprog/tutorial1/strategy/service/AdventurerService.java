package id.ac.ui.cs.advprog.tutorial1.strategy.service;

import id.ac.ui.cs.advprog.tutorial1.strategy.core.Adventurer;
import id.ac.ui.cs.advprog.tutorial1.strategy.core.AttackBehavior;
import id.ac.ui.cs.advprog.tutorial1.strategy.core.DefenseBehavior;

public interface AdventurerService {
    Iterable<Adventurer> findAll();

    Adventurer findByAlias(String alias);

    void changeStrategy(String alias, String attackType, String defenseType);

    Iterable<AttackBehavior> getAttackBehaviors();

    Iterable<DefenseBehavior> getDefenseBehaviors();
}

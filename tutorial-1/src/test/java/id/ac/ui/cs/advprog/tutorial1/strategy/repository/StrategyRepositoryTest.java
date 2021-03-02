package id.ac.ui.cs.advprog.tutorial1.strategy.repository;

import id.ac.ui.cs.advprog.tutorial1.strategy.core.AttackBehavior;
import id.ac.ui.cs.advprog.tutorial1.strategy.core.AttackWithSword;
import id.ac.ui.cs.advprog.tutorial1.strategy.core.DefendWithShield;
import id.ac.ui.cs.advprog.tutorial1.strategy.core.DefenseBehavior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StrategyRepositoryTest {

    private StrategyRepository strategyRepository;

    @BeforeEach
    public void setUp() {
        strategyRepository = new StrategyRepository();
    }

    @Test
    public void testStrategyRepositoryOnAddingAttackBehavior() {
        strategyRepository.addAttackBehavior(new AttackWithSword());
        Iterable<AttackBehavior> attackBehaviors = strategyRepository.getAttackBehaviors();

        assertThat(attackBehaviors).isNotEmpty();
    }

    @Test
    public void testStrategyRepositoryOnAddingDefenseBehavior() {
        strategyRepository.addDefenseBehavior(new DefendWithShield());
        Iterable<DefenseBehavior> defenseBehaviors = strategyRepository.getDefenseBehaviors();

        assertThat(defenseBehaviors).isNotEmpty();
    }

    @Test
    public void testStrategyRepositoryOnFindingAttackBehaviorByType() {
        AttackBehavior attackInstance = new AttackWithSword();
        strategyRepository.addAttackBehavior(attackInstance);

        AttackBehavior fetchedAttack = strategyRepository.getAttackBehaviorByType(attackInstance.getType());

        assertThat(fetchedAttack).isNotNull();
        assertThat(fetchedAttack.getType()).isEqualTo(attackInstance.getType());
    }

    @Test
    public void testStrategyRepositoryOnFindingDefenseBehaviorByType() {
        DefenseBehavior defenseInstance = new DefendWithShield();
        strategyRepository.addDefenseBehavior(defenseInstance);

        DefenseBehavior fetchedDefense = strategyRepository.getDefenseBehaviorByType(defenseInstance.getType());

        assertThat(fetchedDefense).isNotNull();
        assertThat(fetchedDefense.getType()).isEqualTo(defenseInstance.getType());
    }
}

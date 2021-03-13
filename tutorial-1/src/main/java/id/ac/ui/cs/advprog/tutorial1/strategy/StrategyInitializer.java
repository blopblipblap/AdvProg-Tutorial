package id.ac.ui.cs.advprog.tutorial1.strategy;

import id.ac.ui.cs.advprog.tutorial1.strategy.core.*;
import id.ac.ui.cs.advprog.tutorial1.strategy.repository.AdventurerRepository;
import id.ac.ui.cs.advprog.tutorial1.strategy.repository.StrategyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class StrategyInitializer {

    @Autowired
    private AdventurerRepository adventurerRepository;

    @Autowired
    private StrategyRepository strategyRepository;

    @PostConstruct
    public void init() {
        this.adventurerRepository.save(new AgileAdventurer());
        this.adventurerRepository.save(new KnightAdventurer());
        this.adventurerRepository.save(new MysticAdventurer());
        this.strategyRepository.addAttackBehavior(new AttackWithGun());
        this.strategyRepository.addAttackBehavior(new AttackWithMagic());
        this.strategyRepository.addAttackBehavior(new AttackWithSword());
        this.strategyRepository.addDefenseBehavior(new DefendWithBarrier());
        this.strategyRepository.addDefenseBehavior(new DefendWithArmor());
        this.strategyRepository.addDefenseBehavior(new DefendWithShield());
    }
}
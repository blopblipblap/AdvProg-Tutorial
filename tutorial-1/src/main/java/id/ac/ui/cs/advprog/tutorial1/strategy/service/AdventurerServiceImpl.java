package id.ac.ui.cs.advprog.tutorial1.strategy.service;

import id.ac.ui.cs.advprog.tutorial1.strategy.core.*;
import id.ac.ui.cs.advprog.tutorial1.strategy.repository.AdventurerRepository;
import id.ac.ui.cs.advprog.tutorial1.strategy.repository.StrategyRepository;
import org.springframework.stereotype.Service;

@Service
public class AdventurerServiceImpl implements AdventurerService {

    private final AdventurerRepository adventurerRepository;

    private final StrategyRepository strategyRepository;


    public AdventurerServiceImpl(
            AdventurerRepository adventurerRepository,
            StrategyRepository strategyRepository) {

        this.adventurerRepository = adventurerRepository;
        this.strategyRepository = strategyRepository;
    }

    @Override
    public Iterable<Adventurer> findAll() {
        return adventurerRepository.findAll();
    }

    @Override
    public Adventurer findByAlias(String alias) {
        return adventurerRepository.findByAlias(alias);
    }

    @Override
    public void changeStrategy(String alias, String attackType, String defenseType) {
        Adventurer adventurer = adventurerRepository.findByAlias(alias);
        AttackBehavior attack = strategyRepository.getAttackBehaviorByType(attackType);
        DefenseBehavior defense = strategyRepository.getDefenseBehaviorByType(defenseType);
        adventurer.setAttackBehavior(attack);
        adventurer.setDefenseBehavior(defense);
    }

    @Override
    public Iterable<AttackBehavior> getAttackBehaviors() {
        return strategyRepository.getAttackBehaviors();
    }

    @Override
    public Iterable<DefenseBehavior> getDefenseBehaviors() {
        return strategyRepository.getDefenseBehaviors();
    }
}

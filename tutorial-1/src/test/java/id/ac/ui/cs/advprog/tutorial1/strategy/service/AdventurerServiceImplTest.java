package id.ac.ui.cs.advprog.tutorial1.strategy.service;

import id.ac.ui.cs.advprog.tutorial1.strategy.core.*;
import id.ac.ui.cs.advprog.tutorial1.strategy.repository.AdventurerRepository;
import id.ac.ui.cs.advprog.tutorial1.strategy.repository.StrategyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AdventurerServiceImplTest {

    @Mock
    private AdventurerRepository adventurerRepository;

    @Mock
    private StrategyRepository strategyRepository;

    @InjectMocks
    AdventurerServiceImpl adventurerService;

    @Test
    public void testWhenFindAllIsCalledItShouldCallAdventurerRepositoryFindAll() {
        Adventurer adventurer = new AgileAdventurer();
        List<Adventurer> adventurerList = new ArrayList<>();
        adventurerList.add(adventurer);
        when(adventurerService.findAll())

			.thenReturn(adventurerList);

        Iterable<Adventurer> calledAdventurerList = adventurerService.findAll();

        verify(adventurerRepository, times(1)).findAll();
        assertThat(calledAdventurerList.iterator().next())

			.isEqualTo(adventurerList.get(0));
    }

    @Test
    public void testWhenFindByAliasIsCalledItShouldCallAdventurerRepositoryFindByAlias() {
        Adventurer adventurer = new AgileAdventurer();
        List<Adventurer> adventurerList = new ArrayList<>();
        adventurerList.add(adventurer);
        when(adventurerService.findByAlias(adventurer.getAlias()))

			.thenReturn(adventurer);

        Adventurer calledAdventurer = adventurerService.findByAlias(adventurer.getAlias());

        verify(adventurerRepository, times(1))

			.findByAlias(adventurer.getAlias());
        assertThat(calledAdventurer).isEqualTo(adventurer);
    }

    @Test
    public void testWhenGetAttackBehaviorsIsCalledItShouldCallStrategyRepositoryGetAttackBehaviors() {
        List<AttackBehavior> attackBehaviors = new ArrayList<>();
        attackBehaviors.add(new AttackWithSword());
        when(adventurerService.getAttackBehaviors()).thenReturn(attackBehaviors);

        Iterable<AttackBehavior> calledAttackBehaviors = adventurerService.getAttackBehaviors();

        verify(strategyRepository, times(1)).getAttackBehaviors();
        assertThat(calledAttackBehaviors.iterator().next())

			.isEqualTo(attackBehaviors.get(0));
    }

    @Test
    public void testWhenGetDefenseBehaviorsIsCalledItShouldCallStrategyRepositoryGetDefenseBehaviors() {
        List<DefenseBehavior> defenseBehaviors = new ArrayList<>();
        defenseBehaviors.add(new DefendWithShield());
        when(adventurerService.getDefenseBehaviors()).thenReturn(defenseBehaviors);

        Iterable<DefenseBehavior> calledDefenseBehaviors = adventurerService.getDefenseBehaviors();

        verify(strategyRepository, times(1)).getDefenseBehaviors();
        assertThat(calledDefenseBehaviors.iterator().next())

			.isEqualTo(defenseBehaviors.get(0));
    }

    @Test
    public void testWhenChangeStrategyIsCalledItShouldChangeAdventurerStrategies() {
        AttackBehavior attackWithSword = new AttackWithSword();
        DefenseBehavior defendWithBarrier = new DefendWithBarrier();
        Adventurer agileAdventurer = new AgileAdventurer();
        when(adventurerService.findByAlias(agileAdventurer.getAlias()))

			.thenReturn(agileAdventurer);
        when(strategyRepository.getAttackBehaviorByType(attackWithSword.getType()))
			.thenReturn(attackWithSword);
        when(strategyRepository.getDefenseBehaviorByType(defendWithBarrier.getType()))
			.thenReturn(defendWithBarrier);

        adventurerService.changeStrategy(
			agileAdventurer.getAlias(),
			attackWithSword.getType(),
			defendWithBarrier.getType()
        );

        verify(adventurerRepository, times(1))
			.findByAlias(agileAdventurer.getAlias());
        verify(strategyRepository, times(1))
			.getAttackBehaviorByType(attackWithSword.getType());
        verify(strategyRepository, times(1))
			.getDefenseBehaviorByType(defendWithBarrier.getType());
        assertThat(agileAdventurer.getAttackBehavior()).isEqualTo(attackWithSword);
        assertThat(agileAdventurer.getDefenseBehavior()).isEqualTo(defendWithBarrier);
    }
}

package id.ac.ui.cs.advprog.tutorial1.strategy.controller;

import id.ac.ui.cs.advprog.tutorial1.strategy.core.*;
import id.ac.ui.cs.advprog.tutorial1.strategy.repository.AdventurerRepository;
import id.ac.ui.cs.advprog.tutorial1.strategy.repository.StrategyRepository;
import id.ac.ui.cs.advprog.tutorial1.strategy.service.AdventurerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = StrategyController.class)
public class StrategyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdventurerRepository adventurerRepository;

    @MockBean
    private StrategyRepository strategyRepository;

    @MockBean
    private AdventurerService adventurerService;

    private List<Adventurer> generateAdventurers() {
        List<Adventurer> adventurers = new ArrayList<>();
        adventurers.add(new AgileAdventurer());
        adventurers.add(new KnightAdventurer());
        adventurers.add(new MysticAdventurer());

        return adventurers;
    }

    private List<AttackBehavior> generateAttackBehaviors() {
        List<AttackBehavior> attackBehaviors = new ArrayList<>();
        attackBehaviors.add(new AttackWithGun());
        attackBehaviors.add(new AttackWithMagic());
        attackBehaviors.add(new AttackWithSword());

        return attackBehaviors;
    }

    private List<DefenseBehavior> generateDefenseBehaviors() {
        List<DefenseBehavior> defenseBehaviors = new ArrayList<>();
        defenseBehaviors.add(new DefendWithArmor());
        defenseBehaviors.add(new DefendWithBarrier());
        defenseBehaviors.add(new DefendWithShield());

        return defenseBehaviors;
    }

    @Test
    public void testWhenAdventurerListURLIsAccessedItShouldContainCorrectDefaultAdventurersModel() throws Exception {
        List<Adventurer> adventurers = generateAdventurers();
        when(adventurerService.findAll()).thenReturn(adventurers);

        mockMvc.perform(get("/adventurer/all"))

			.andExpect(status().isOk())
			.andExpect(model().attribute("adventurers", hasSize(3)))
			.andExpect(model().attribute("adventurers", hasItem(
				allOf(
				    hasProperty("attackBehavior", instanceOf(AttackWithGun.class)),
                    hasProperty("defenseBehavior", instanceOf(DefendWithBarrier.class))
				)
			)))
			.andExpect(model().attribute("adventurers", hasItem(
				allOf(
					hasProperty("attackBehavior", instanceOf(AttackWithSword.class)),
					hasProperty("defenseBehavior", instanceOf(DefendWithArmor.class))
				)
			)))
			.andExpect(model().attribute("adventurers", hasItem(
				allOf(
					hasProperty("attackBehavior", instanceOf(AttackWithMagic.class)),
					hasProperty("defenseBehavior", instanceOf(DefendWithShield.class))
				)
			)));
    }

    @Test
    public void testWhenAdventurerListURLIsAccessedItShouldContainCorrectAttackBehaviorsModel() throws Exception {
        List<AttackBehavior> attackBehaviors = generateAttackBehaviors();
        when(adventurerService.getAttackBehaviors()).thenReturn(attackBehaviors);

        mockMvc.perform(get("/adventurer/all"))

			.andExpect(status().isOk())
			.andExpect(model().attribute("attackBehaviors", hasSize(3)));
    }

    @Test
    public void testWhenAdventurerListURLIsAccessedItShouldContainCorrectDefenseBehaviorsModel() throws Exception {
        List<DefenseBehavior> defenseBehaviors = generateDefenseBehaviors();
        when(adventurerService.getDefenseBehaviors()).thenReturn(defenseBehaviors);

        mockMvc.perform(get("/adventurer/all"))

			.andExpect(status().isOk())
			.andExpect(model().attribute("defenseBehaviors", hasSize(3)));
    }

    @Test
    public void testChangeStrategyUrlCanChangeAnAdventurerStrategies() throws Exception {
        Adventurer knight = new KnightAdventurer();
        AttackBehavior attackWithGun = new AttackWithGun();
        DefenseBehavior defendWithBarrier = new DefendWithBarrier();

        when(adventurerRepository.findByAlias(knight.getAlias()))

			.thenReturn(knight);
        when(strategyRepository.getAttackBehaviorByType(attackWithGun.getType()))
			.thenReturn(attackWithGun);
        when(strategyRepository.getDefenseBehaviorByType(defendWithBarrier.getType()))
			.thenReturn(defendWithBarrier);
        doAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            Adventurer adventurer = adventurerRepository.findByAlias((String) args[0]);
            AttackBehavior attackBehavior = strategyRepository.getAttackBehaviorByType((String) args[1]);
            DefenseBehavior defenseBehavior = strategyRepository.getDefenseBehaviorByType((String) args[2]);
            adventurer.setAttackBehavior(attackBehavior);
            adventurer.setDefenseBehavior(defenseBehavior);
            return null;
        }).when(adventurerService).changeStrategy(

			knight.getAlias(),
			attackWithGun.getType(),
			defendWithBarrier.getType()
        );

        mockMvc.perform(
			post("/adventurer/change-strategy")
				.param("alias", knight.getAlias())
				.param("attackType", attackWithGun.getType())
				.param("defenseType", defendWithBarrier.getType()))
			.andExpect(status().is3xxRedirection())
			.andExpect(redirectedUrl("/adventurer/all"));

        assertThat(knight.getAttackBehavior()).isInstanceOf(AttackWithGun.class);
        assertThat(knight.getDefenseBehavior()).isInstanceOf(DefendWithBarrier.class);
    }
}

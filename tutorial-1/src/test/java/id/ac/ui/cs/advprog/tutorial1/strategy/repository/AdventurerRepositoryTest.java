package id.ac.ui.cs.advprog.tutorial1.strategy.repository;

import id.ac.ui.cs.advprog.tutorial1.strategy.core.Adventurer;
import id.ac.ui.cs.advprog.tutorial1.strategy.core.AgileAdventurer;
import id.ac.ui.cs.advprog.tutorial1.strategy.core.KnightAdventurer;
import id.ac.ui.cs.advprog.tutorial1.strategy.core.MysticAdventurer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdventurerRepositoryTest {

    private AdventurerRepository adventurerRepository;

    @BeforeEach
    public void setUp() {
        adventurerRepository = new AdventurerRepository();
    }

    @Test
    public void testAdventurerRepositoryOnSavingNewAdventurerObject() throws Exception {
        Class<?> adventurerRepositoryClass = Class.forName(
                "id.ac.ui.cs.advprog.tutorial1.strategy.repository.AdventurerRepository"
        );
        Adventurer adventurerInstance = new AgileAdventurer();
        Method save = adventurerRepositoryClass.getDeclaredMethod("save", Adventurer.class);

        Adventurer savedAdventurer = (Adventurer) save.invoke(new AdventurerRepository(), adventurerInstance);

        assertEquals(adventurerInstance, savedAdventurer);
    }

    @Test
    public void testAdventurerRepositoryOnSavingExistingAdventurerObject() throws Exception {
        Class<?> adventurerRepositoryClass = Class.forName(
                "id.ac.ui.cs.advprog.tutorial1.strategy.repository.AdventurerRepository"
        );
        Adventurer adventurerInstance = new AgileAdventurer();
        AdventurerRepository adventurerRepositoryInstance = new AdventurerRepository();
        Method save = adventurerRepositoryClass.getDeclaredMethod("save", Adventurer.class);
        save.invoke(adventurerRepositoryInstance, adventurerInstance);

        Adventurer updatedAdventurer = (Adventurer) save.invoke(adventurerRepositoryInstance, adventurerInstance);

        assertEquals(adventurerInstance, updatedAdventurer);
    }

    @Test
    public void testAdventurerRepositoryOnFindingSavedAdventurerByAlias() {
        Adventurer adventurerInstance = new AgileAdventurer();
        adventurerRepository.save(adventurerInstance);

        Adventurer adventurer = adventurerRepository.findByAlias(adventurerInstance.getAlias());

        assertThat(adventurer).isNotNull();
        assertThat(adventurer.getAlias()).isEqualTo(adventurerInstance.getAlias());
        assertThat(adventurer.getAttackBehavior()).isEqualTo(adventurerInstance.getAttackBehavior());
        assertThat(adventurer.getDefenseBehavior()).isEqualTo(adventurerInstance.getDefenseBehavior());
    }

    @Test
    public void testAdventurerRepositoryOnFindingNonExistingAdventurerByAlias() {
        Adventurer notFoundAdventurer = adventurerRepository.findByAlias("Knight");

        assertThat(notFoundAdventurer).isNull();
    }

    @Test
    public void testAdventurerRepositoryOnFindingAllAdventurers() {
        adventurerRepository.save(new AgileAdventurer());
        adventurerRepository.save(new KnightAdventurer());
        adventurerRepository.save(new MysticAdventurer());

        List<Adventurer> allAdventurers = (List<Adventurer>) adventurerRepository.findAll();

        assertThat(allAdventurers.size()).isEqualTo(3);
    }
}

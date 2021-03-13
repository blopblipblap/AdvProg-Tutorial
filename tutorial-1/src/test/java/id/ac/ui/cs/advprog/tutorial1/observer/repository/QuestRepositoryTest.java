package id.ac.ui.cs.advprog.tutorial1.observer.repository;

import id.ac.ui.cs.advprog.tutorial1.observer.core.Quest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class QuestRepositoryTest {

    private QuestRepository questRepository;

    @BeforeEach
    public void setUp() {
        questRepository = new QuestRepository();
    }

    @Test
    public void testSaveNewQuestShouldAddItToTheRepository() {
        Quest newQuest = new Quest();
        newQuest.setTitle("Dummy quest");
        newQuest.setType("E");

        questRepository.save(newQuest);
        Map<String, Quest> repositoryQuests = questRepository.getQuests();

        assertThat(repositoryQuests).hasSize(1);
        assertThat(repositoryQuests).containsValue(newQuest);
    }

    @Test
    public void testSaveExistingQuestWithGivenTitleShouldNotSaveItToTheRepository() {
        Quest savedQuest = new Quest();
        savedQuest.setTitle("Dummy quest");
        savedQuest.setType("R");
        questRepository.save(savedQuest);
        Quest newQuest = new Quest();
        newQuest.setTitle("Dummy quest");
        newQuest.setType("R");

        questRepository.save(newQuest);
        Map<String, Quest> repositoryQuests = questRepository.getQuests();

        assertThat(repositoryQuests).size().isNotEqualTo(2);
    }
}

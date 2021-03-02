package id.ac.ui.cs.advprog.tutorial1.observer.service;

import id.ac.ui.cs.advprog.tutorial1.observer.core.Quest;
import id.ac.ui.cs.advprog.tutorial1.observer.repository.QuestRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class GuildServiceImplTest {

    @Mock
    private QuestRepository questRepository;

    @InjectMocks
    private GuildServiceImpl guildService;

    @Test
    public void whenAddQuestIsCalledItShouldCallQuestRepositorySave() {
        Quest quest = new Quest();
        quest.setTitle("Dummy");
        quest.setType("D");

        guildService.addQuest(quest);

        verify(questRepository, times(1)).save(quest);
    }
}

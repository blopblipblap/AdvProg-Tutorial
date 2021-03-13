package id.ac.ui.cs.advprog.tutorial1.observer.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AgileAdventurerTest {

    private AgileAdventurer agileAdventurer;

    @Mock
    private Guild guild;

    @BeforeEach
    public void setUp() {
        agileAdventurer = new AgileAdventurer(guild);
    }

    @Test
    public void whenUpdateMethodIsCalledItShouldAcceptDeliveryQuestType() {
        Quest deliveryQuest = new Quest();
        deliveryQuest.setTitle("Dummy");
        deliveryQuest.setType("D");
        when(guild.getQuestType()).thenReturn(deliveryQuest.getType());
        when(guild.getQuest()).thenReturn(deliveryQuest);

        agileAdventurer.update();
        List<Quest> agileQuestList = agileAdventurer.getQuests();

        assertThat(agileQuestList).contains(deliveryQuest);
    }

    @Test
    public void whenUpdateMethodIsCalledItShouldAcceptRumbleQuestType() {
        Quest rumbleQuest = new Quest();
        rumbleQuest.setTitle("Dummy");
        rumbleQuest.setType("R");
        when(guild.getQuestType()).thenReturn(rumbleQuest.getType());
        when(guild.getQuest()).thenReturn(rumbleQuest);

        agileAdventurer.update();
        List<Quest> agileQuestList = agileAdventurer.getQuests();

        assertThat(agileQuestList).contains(rumbleQuest);
    }

    @Test
    public void whenUpdateMethodIsCalledItShouldNotAcceptEscortQuestType() {
        Quest escortQuest = new Quest();
        escortQuest.setTitle("Dummy");
        escortQuest.setType("E");
        when(guild.getQuestType()).thenReturn(escortQuest.getType());

        agileAdventurer.update();
        List<Quest> agileQuestList = agileAdventurer.getQuests();

        assertThat(agileQuestList).doesNotContain(escortQuest);
    }
}

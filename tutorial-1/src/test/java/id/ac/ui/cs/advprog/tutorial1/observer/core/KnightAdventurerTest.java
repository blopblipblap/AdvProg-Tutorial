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
public class KnightAdventurerTest {

    private KnightAdventurer knightAdventurer;

    @Mock
    private Guild guild;

    @BeforeEach
    public void setUp() {
        knightAdventurer = new KnightAdventurer(guild);
    }

    @Test
    public void whenUpdateMethodIsCalledItShouldAcceptDeliveryQuestType() {
        Quest deliveryQuest = new Quest();
        deliveryQuest.setTitle("Dummy");
        deliveryQuest.setType("D");
        when(guild.getQuest()).thenReturn(deliveryQuest);

        knightAdventurer.update();
        List<Quest> agileQuestList = knightAdventurer.getQuests();

        assertThat(agileQuestList).contains(deliveryQuest);
    }

    @Test
    public void whenUpdateMethodIsCalledItShouldAcceptRumbleQuestType() {
        Quest rumbleQuest = new Quest();
        rumbleQuest.setTitle("Dummy");
        rumbleQuest.setType("R");
        when(guild.getQuest()).thenReturn(rumbleQuest);

        knightAdventurer.update();
        List<Quest> agileQuestList = knightAdventurer.getQuests();

        assertThat(agileQuestList).contains(rumbleQuest);
    }

    @Test
    public void whenUpdateMethodIsCalledItShouldAcceptEscortQuestType() {
        Quest escortQuest = new Quest();
        escortQuest.setTitle("Dummy");
        escortQuest.setType("E");
        when(guild.getQuest()).thenReturn(escortQuest);

        knightAdventurer.update();
        List<Quest> agileQuestList = knightAdventurer.getQuests();

        assertThat(agileQuestList).contains(escortQuest);
    }
}

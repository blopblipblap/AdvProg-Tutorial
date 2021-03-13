package id.ac.ui.cs.advprog.tutorial1.observer.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GuildTest {

    private Guild guild;

    @BeforeEach
    public void setUp() {
        guild = new Guild();
    }

    @Test
    public void testWhenAddQuestIsCalledItShouldSetTheQuestProperty() {
        Quest quest = new Quest();
        quest.setTitle("Dummy");
        quest.setType("R");

        guild.addQuest(quest);

        assertThat(guild.getQuest()).isSameAs(quest);
    }
}

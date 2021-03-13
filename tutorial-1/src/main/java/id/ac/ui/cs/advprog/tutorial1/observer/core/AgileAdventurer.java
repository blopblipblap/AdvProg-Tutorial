package id.ac.ui.cs.advprog.tutorial1.observer.core;

import id.ac.ui.cs.advprog.tutorial1.observer.repository.QuestRepository;

public class AgileAdventurer extends Adventurer {

    public AgileAdventurer(Guild guild) {
        this.name = "Agile";
        this.guild = guild;
    }


    @Override
    public void update() {
        if (guild.getQuestType().equals("R")) {
            this.getQuests().add(guild.getQuest());
        } else if (guild.getQuestType().equals("D")) {
            this.getQuests().add(guild.getQuest());
        }
    }
}

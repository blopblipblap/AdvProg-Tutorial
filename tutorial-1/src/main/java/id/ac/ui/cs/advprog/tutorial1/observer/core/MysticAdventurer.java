package id.ac.ui.cs.advprog.tutorial1.observer.core;

public class MysticAdventurer extends Adventurer {

    public MysticAdventurer(Guild guild) {
        this.name = "Mystic";
        this.guild = guild;
        //ToDo: Complete Me
        Quest deliveryQuest = new Quest();
        Quest escortQuest = new Quest();
    }

    //ToDo: Complete Me
    @Override
    public void update() {
        if (guild.getQuestType().equals("E")) {
            this.getQuests().add(guild.getQuest());
        } else if (guild.getQuestType().equals("D")) {
            this.getQuests().add(guild.getQuest());
        }
    }
}

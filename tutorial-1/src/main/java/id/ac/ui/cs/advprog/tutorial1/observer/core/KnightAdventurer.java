package id.ac.ui.cs.advprog.tutorial1.observer.core;

public class KnightAdventurer extends Adventurer {

    public KnightAdventurer(Guild guild) {
        this.name = "Knight";
        this.guild = guild;
    }

    @Override
    public void update() {
        this.getQuests().add(guild.getQuest());
    }
}

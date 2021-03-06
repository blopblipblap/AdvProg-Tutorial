package id.ac.ui.cs.advprog.tutorial1.observer.core;

public class AgileAdventurer extends Adventurer {

    public AgileAdventurer(Guild guild) {
        this.name = "Agile";
        //ToDo: Complete Me
        this.guild = guild;
    }

    //ToDo: Complete Me

    @Override
    public void update() {
        Quest q = guild.getQuest();
        if (q.getType().equals("R")) {

        }
    }
}

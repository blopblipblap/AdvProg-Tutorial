package id.ac.ui.cs.advprog.tutorial1.observer.core;

public class KnightAdventurer extends Adventurer {

    public KnightAdventurer(Guild guild) {
        this.name = "Knight";
        this.guild = guild;
        //ToDo: Complete Me
        Quest deliveryQuest = new Quest();
        Quest rumbleQuest = new Quest();
        Quest escortQuest = new Quest();
    }

    //ToDo: Complete Me
    @Override
    public void update() {
        System.out.println("apa nii");
    }
}

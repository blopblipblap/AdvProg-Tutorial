package id.ac.ui.cs.advprog.tutorial1.observer.core;

import id.ac.ui.cs.advprog.tutorial1.observer.repository.QuestRepository;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private List<Adventurer> adventurers = new ArrayList<>();
    private Quest quest;

    public void add(Adventurer adventurer) {
        adventurers.add(adventurer);
    }

    public void addQuest(Quest quest) {
        this.quest = quest;
        broadcast();
    }

    public String getQuestType () {return quest.getType();}

    public Quest getQuest() {return quest;}

    public List<Adventurer> getAdventurers() {
        return adventurers;
    }

    private void broadcast() {
        for (int i = 0; i < adventurers.size(); i++) {
            Adventurer notifiedAdv = (Adventurer) adventurers.get(i);
            notifiedAdv.update();
        }
    }
}

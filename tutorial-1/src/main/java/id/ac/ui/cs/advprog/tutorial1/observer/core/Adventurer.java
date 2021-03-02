package id.ac.ui.cs.advprog.tutorial1.observer.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Adventurer {
    protected Guild guild;
    protected String name;
    private List<Quest> quests = new ArrayList<>();

    public abstract void update();

    public String getName() {
        return this.name;
    }

    public List<Quest> getQuests() {
        return this.quests;
    }
}

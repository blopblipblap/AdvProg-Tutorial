package id.ac.ui.cs.advprog.tutorial2.command.core.spirit;

import id.ac.ui.cs.advprog.tutorial2.command.core.spell.Spell;

import java.util.LinkedList;
import java.util.List;

public class Familiar {
    private List<String> lifeArchive;
    private FamiliarState prevState;
    private FamiliarState currState;
    private String race;

    public Familiar(String race) {
        lifeArchive = new LinkedList<>();
        prevState = FamiliarState.SEALED;
        currState = FamiliarState.SEALED;
        this.race = race;
    }

    public Familiar() {
        this("Unknown Familiar");
    }

    public void summon() {
        prevState = currState;
        currState = FamiliarState.ACTIVE;
        lifeArchive.add(race + " is summoned");
    }

    public void seal() {
        prevState = currState;
        currState = FamiliarState.SEALED;
        lifeArchive.add(race + " is sealed");
    }

    public FamiliarState getPrevState() { return prevState; }

    public String getRace() { return this.race; }

    public List<String> getLifeArchive() { return lifeArchive; }

}
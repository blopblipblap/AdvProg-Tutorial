package id.ac.ui.cs.advprog.tutorial2.command.core.spirit;

import java.util.LinkedList;
import java.util.List;

public class HighSpirit {
    List<String> lifeArchive;
    private HighSpiritState prevState;
    private HighSpiritState currState;
    private String race;

    public HighSpirit(String race) {
        lifeArchive = new LinkedList<>();
        prevState = HighSpiritState.SEALED;
        currState = HighSpiritState.SEALED;
        this.race = race;
    }

    public HighSpirit() {
        this("Unknown Spirit");
    }

    public void attackStance() {
        prevState = currState;
        currState = HighSpiritState.ATTACK;
        lifeArchive.add(race + " is in attack stance");
    }

    public void defenseStance() {
        prevState = currState;
        currState = HighSpiritState.DEFEND;
        lifeArchive.add(race + " is in defense stance");
    }

    public void stealthStance() {
        prevState = currState;
        currState = HighSpiritState.STEALTH;
        lifeArchive.add(race + " is in stealth stance");
    }

    public void seal() {
        prevState = currState;
        currState = HighSpiritState.SEALED;
        lifeArchive.add(race + " is sealed");
    }

    public HighSpiritState getPrevState() { return prevState; }

    public String getRace() { return this.race; }

    public List<String> getLifeArchive() { return lifeArchive; }
}

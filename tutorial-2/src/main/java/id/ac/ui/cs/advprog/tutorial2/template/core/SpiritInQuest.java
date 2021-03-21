package id.ac.ui.cs.advprog.tutorial2.template.core;

import java.util.ArrayList;
import java.util.List;

public abstract class SpiritInQuest {

    public List attackPattern() {
        List list = new ArrayList();
        list.add(this.summon());
        list.add(this.getReady());
        list.add(this.buff());
        list.add(this.attackWithBuster());
        list.add(this.attackWithQuick());
        list.add(this.attackWithArts());
        list.add(this.attackWithSpecialSkill());
        return list;
    }


    public String summon() {
        return "Summon a Spirit...";
    }

    public String getReady() {
        return "Spirit ready to enter the Quest";
    }

    protected abstract String buff();

    protected abstract String attackWithBuster();

    protected abstract String attackWithQuick();

    protected abstract String attackWithArts();

    protected abstract String attackWithSpecialSkill();
}

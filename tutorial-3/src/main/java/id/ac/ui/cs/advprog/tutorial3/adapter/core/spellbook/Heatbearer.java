package id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook;


public class Heatbearer implements Spellbook {

    private String holderName;

    public Heatbearer(String holderName) {
        this.holderName = holderName;
    }

    @Override
    public String smallSpell() {
        return "Enemy scarred";
    }

    @Override
    public String largeSpell() {
        return "EXPUULOOOOSHHHIOONNNN!";
    }

    @Override
    public String getName() {
        return "Heat Bearer";
    }

    @Override
    public String getHolderName() { return holderName; }
}
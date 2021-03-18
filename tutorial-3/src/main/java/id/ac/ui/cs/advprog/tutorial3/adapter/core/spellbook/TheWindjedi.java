package id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook;

public class TheWindjedi implements Spellbook {

    private String holderName;

    public TheWindjedi(String holderName) {
        this.holderName = holderName;
    }

    @Override
    public String smallSpell() {
        return "Small musical attack launched";
    }

    @Override
    public String largeSpell() {
        return "Orchestra-class music attack launched";
    }

    @Override
    public String getName() {
        return "The Windjedi";
    }

    @Override
    public String getHolderName() { return holderName; }
}
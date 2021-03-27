package id.ac.ui.cs.advprog.tutorial3.facade.core.misc;

import id.ac.ui.cs.advprog.tutorial3.facade.core.codex.Codex;

public class Spell {
    private String text;
    private Codex codex;

    public Spell(String text, Codex codex){
        this.text = text;
        this.codex = codex;
    }

    public String getText(){
        return text;
    }

    public Codex getCodex(){
        return codex;
    }
}

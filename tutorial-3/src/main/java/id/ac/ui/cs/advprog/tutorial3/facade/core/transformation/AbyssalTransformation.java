package id.ac.ui.cs.advprog.tutorial3.facade.core.transformation;

import id.ac.ui.cs.advprog.tutorial3.facade.core.misc.Spell;
import id.ac.ui.cs.advprog.tutorial3.facade.core.codex.Codex;

/**
 * Kelas ini melakukan cipher transposisi rotasi
*/
public class AbyssalTransformation {
    private int key;

    public AbyssalTransformation(int key){
        this.key = key;
    }

    public AbyssalTransformation(){
        this(5);
    }

    public Spell encode(Spell spell){
        return process(spell, true);
    }

    public Spell decode(Spell spell){
        return process(spell, false);
    }

    private Spell process(Spell spell, boolean encode){
        String text = spell.getText();
        Codex codex = spell.getCodex();
        int selector = encode ? -1 : 1;
        int n = text.length();
        char[] res = new char[n];
        for(int i = 0; i < n; i++){
            int newIdx = i + key * selector;
            newIdx = newIdx < 0 ? n + newIdx : newIdx % n;
            res[i] = text.charAt(newIdx);
        }

        return new Spell(new String(res), codex);
    }
}

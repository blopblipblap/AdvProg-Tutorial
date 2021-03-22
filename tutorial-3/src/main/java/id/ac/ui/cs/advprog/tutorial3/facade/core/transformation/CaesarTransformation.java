package id.ac.ui.cs.advprog.tutorial3.facade.core.transformation;

import id.ac.ui.cs.advprog.tutorial3.facade.core.misc.Spell;
import id.ac.ui.cs.advprog.tutorial3.facade.core.codex.Codex;

/**
 * Kelas ini melakukan cipher transposisi rotasi
 */
public class CaesarTransformation {
    private int key;

    public CaesarTransformation(int key){
        this.key = key;
    }

    public CaesarTransformation(){
        this(3);
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
        int selector = encode ? 1 : -1;
        int n = text.length();
        int codexSize = codex.getCharSize();
        char[] res = new char[n];
        for(int i = 0; i < n; i++){
            char oldChar = text.charAt(i);
            int charIdx = codex.getIndex(oldChar);
            int newCharIdx = charIdx + key * selector;
            newCharIdx = newCharIdx < 0 ? codexSize + newCharIdx : newCharIdx % codexSize;
            res[i] = codex.getChar(newCharIdx);
        }
        return new Spell(new String(res), codex);
    }
}

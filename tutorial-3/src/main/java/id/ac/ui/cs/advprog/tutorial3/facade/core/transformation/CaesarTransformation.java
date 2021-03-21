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
        char[] res = new char[n];
        for(int i = 0; i < n; i++){
            char oldChar = text.charAt(i);
            int oldCharASCII = (int) oldChar;
            if (Character.isUpperCase(oldChar)) {
                int newASCII = oldCharASCII - 65;
                int newCharCaesar = (newASCII + key * selector) % 26;
                char newChar = (char) (newCharCaesar + 65);
                res[i] = newChar;
            } else if (oldChar == ' ') {
                res[i] = oldChar;
            } else {
                int newASCII = oldCharASCII - 97;
                int newCharCaesar = (newASCII + key * selector) % 26;
                char newChar = (char) (newCharCaesar + 97);
                res[i] = newChar;
            }
        }
        return new Spell(new String(res), codex);
    }
}

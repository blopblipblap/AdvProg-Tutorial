package id.ac.ui.cs.advprog.tutorial3.facade.core.transformation;

import id.ac.ui.cs.advprog.tutorial3.facade.core.misc.Spell;
import id.ac.ui.cs.advprog.tutorial3.facade.core.codex.Codex;
/**
 * Kelas ini mengimplementasikan sistem kriptografi Vigenere
*/
public class CelestialTransformation {
    private int[] key;

    public CelestialTransformation(int[] key){
        this.key = key;
    }

    /**
     * Constructor
     * @param strKey string a-z saja
    */
    public CelestialTransformation(String strKey){
        this(new int[strKey.length()]);
        for(int i = 0; i < key.length; i++){
            key[i] = (strKey.charAt(i) - 'a');
        }
    }

    public CelestialTransformation(){
        this("iamtheboneofmysword");
    }

    public Spell encode(Spell spell){
        return process(spell, true);
    }

    public Spell decode(Spell spell){
        return process(spell, false);
    }

    private Spell process(Spell spell, boolean encode){
        int selector = encode ? 1 : -1;
        String text = spell.getText();
        Codex codex = spell.getCodex();
        int codexSize = codex.getCharSize();
        char[] res = new char[text.length()];
        for(int i = 0; i < res.length; i++){
            int keyIdx = i % key.length;
            char oldChar = text.charAt(i);
            int charIdx = codex.getIndex(oldChar);
            int newCharIdx = charIdx + key[keyIdx] * selector;
            newCharIdx = newCharIdx < 0 ? codexSize + newCharIdx : newCharIdx % codexSize;
            res[i] = codex.getChar(newCharIdx);
        }

        return new Spell(new String(res), codex);
    }
}

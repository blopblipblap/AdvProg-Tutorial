package id.ac.ui.cs.advprog.tutorial3.facade.core.codex;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public abstract class Codex {
    private char[] charArr;
    private Map<Character, Integer> reverseIndex;

    protected Codex(char[] charArr, Map<Character, Integer> reverseIndex){
        this.charArr = charArr;
        this.reverseIndex = reverseIndex;
    }

    protected Codex(char[] charArr){
        this(charArr, new TreeMap<>());
        initReverseIndex();
    }

    private void initReverseIndex(){
        for(int i = 0; i < charArr.length; i++){
            reverseIndex.put(charArr[i], i);
        }
    }

    public char[] getCharacters(){
        return charArr;
    }

    public int getCharSize(){
        return charArr.length;
    }

    public Map<Character, Integer> getReverseIndex(){
        return reverseIndex;
    }

    public int getIndex(char ch){
        return reverseIndex.containsKey(ch) ? reverseIndex.get(ch) : -1;
    }

    public char getChar(int i){
        return charArr[i];
    }
}

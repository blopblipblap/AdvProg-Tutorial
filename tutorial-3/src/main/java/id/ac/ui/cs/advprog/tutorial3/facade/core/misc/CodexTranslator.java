package id.ac.ui.cs.advprog.tutorial3.facade.core.misc;

import id.ac.ui.cs.advprog.tutorial3.facade.core.codex.Codex;
import java.util.Arrays;

public class CodexTranslator {
    /**
     * Melakukan substitusi monoalphabetic dari codex satu ke codex lainnya
     * @param spell : kalimat yang ingin di-transformasi
     * @param newCodex : jenis codex baru yang diinginkan
     * @throws IllegalArgumentException saat Codex lama dan Codex baru tidak memiliki jumlah karakter yang sama
     * @return hasil transformasi dalam bentuk String
    */
    public static Spell translate(Spell spell, Codex newCodex) throws IllegalArgumentException {
        String str = spell.getText();
        Codex oldCodex = spell.getCodex();
        int n = str.length();
        char[] res = new char[n];
        if(oldCodex.getCharSize() != newCodex.getCharSize()){
            throw new IllegalArgumentException("Jumlah karakter pada kedua Codex tidak sama");
        } else {
            for(int i = 0; i < n; i++){
                char oldChar = str.charAt(i);
                int charIdx = oldCodex.getIndex(oldChar);
                char newChar = newCodex.getChar(charIdx);
                res[i] = newChar;
            }
        }

        return new Spell(new String(res), newCodex);
    }
}

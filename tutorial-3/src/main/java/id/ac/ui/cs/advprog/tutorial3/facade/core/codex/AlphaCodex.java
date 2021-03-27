package id.ac.ui.cs.advprog.tutorial3.facade.core.codex;

import java.util.Arrays;

public class AlphaCodex extends Codex {
    private static AlphaCodex self = null;
    private static final char[] ALL_CHARS = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' ',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    private AlphaCodex(){
        super(ALL_CHARS);
    }

    public static AlphaCodex getInstance(){
        if(self == null){
            self = new AlphaCodex();
        }

        return self;
    }
}
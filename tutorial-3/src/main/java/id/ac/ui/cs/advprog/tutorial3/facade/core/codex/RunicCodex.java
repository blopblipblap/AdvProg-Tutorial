package id.ac.ui.cs.advprog.tutorial3.facade.core.codex;

import java.util.Arrays;

public class RunicCodex extends Codex {
    private static RunicCodex self = null;
    private static final char[] ALL_CHARS = {
        ')', '!', '@', '#', '$', '%', '^', '&', '*', '(', '_',
        '{', '}', '[', ']', '|', ':', ';', ',', '.', '<', '>', '?', '/',
        '=', '-', '+', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p',
        'J', 'K', 'L', 'z', 'x', 'c', 'v', 'b', 'n', 'm', 'a', 's', 'd',
        'Z', 'X', 'C', 'V', 'B', 'N', 'M', 'A', 'S', 'D', 'F', 'G', 'H'
    };

    private RunicCodex(){
        super(ALL_CHARS);
    }

    public static RunicCodex getInstance(){
        if(self == null){
            self = new RunicCodex();
        }

        return self;
    }
}

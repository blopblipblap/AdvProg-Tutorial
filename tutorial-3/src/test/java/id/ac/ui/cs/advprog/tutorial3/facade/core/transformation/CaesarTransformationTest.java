package id.ac.ui.cs.advprog.tutorial3.facade.core.transformation;

import id.ac.ui.cs.advprog.tutorial3.facade.core.codex.AlphaCodex;
import id.ac.ui.cs.advprog.tutorial3.facade.core.codex.Codex;
import id.ac.ui.cs.advprog.tutorial3.facade.core.misc.Spell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CaesarTransformationTest {
    private Class<?> caesarClass;

    @BeforeEach
    public void setup() throws Exception {
        caesarClass = Class.forName(
                "id.ac.ui.cs.advprog.tutorial3.facade.core.transformation.CaesarTransformation");
    }

    @Test
    public void testCaesarHasEncodeMethod() throws Exception {
        Method translate = caesarClass.getDeclaredMethod("encode", Spell.class);
        int methodModifiers = translate.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
    }

    @Test
    public void testCaesarEncodesCorrectly() throws Exception {
        String text = "Safira and I went to a blacksmith to forge our sword";
        Codex codex = AlphaCodex.getInstance();
        Spell spell = new Spell(text, codex);
        String expected = "VdiludCdqgCLCzhqwCwrCdCeodfnvplwkCwrCirujhCrxuCvzrug";

        Spell result = new CaesarTransformation().encode(spell);
        assertEquals(expected, result.getText());
    }

    @Test
    public void testCaesarEncodesCorrectlyWithCustomKey() throws Exception {
        String text = "Safira and I went to a blacksmith to forge our sword";
        Codex codex = AlphaCodex.getInstance();
        Spell spell = new Spell(text, codex);
        String expected = "YgloxgFgtjFOF2ktzFzuFgFhrgiqysoznFzuFluxmkFu0xFy2uxj";

        Spell result = new CaesarTransformation(6).encode(spell);
        assertEquals(expected, result.getText());
    }

    @Test
    public void testCelestialHasDecodeMethod() throws Exception {
        Method translate = caesarClass.getDeclaredMethod("decode", Spell.class);
        int methodModifiers = translate.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
    }

    @Test
    public void testCaesarDecodesCorrectly() throws Exception {
        String text = "VdiludCdqgCLCzhqwCwrCdCeodfnvplwkCwrCirujhCrxuCvzrug";
        Codex codex = AlphaCodex.getInstance();
        Spell spell = new Spell(text, codex);
        String expected = "Safira and I went to a blacksmith to forge our sword";

        Spell result = new CaesarTransformation().decode(spell);
        assertEquals(expected, result.getText());
    }

    @Test
    public void testCaesarDecodesCorrectlyWithCustomKey() throws Exception {
        String text = "YgloxgFgtjFOF2ktzFzuFgFhrgiqysoznFzuFluxmkFu0xFy2uxj";
        Codex codex = AlphaCodex.getInstance();
        Spell spell = new Spell(text, codex);
        String expected = "Safira and I went to a blacksmith to forge our sword";

        Spell result = new CaesarTransformation(6).decode(spell);
        assertEquals(expected, result.getText());
    }
}

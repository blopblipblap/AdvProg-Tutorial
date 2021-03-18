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

public class CelestialTransformationTest {
    private Class<?> celestialClass;

    @BeforeEach
    public void setup() throws Exception {
        celestialClass = Class.forName(
                "id.ac.ui.cs.advprog.tutorial3.facade.core.transformation.CelestialTransformation");
    }

    @Test
    public void testCelestialHasEncodeMethod() throws Exception {
        Method translate = celestialClass.getDeclaredMethod("encode", Spell.class);
        int methodModifiers = translate.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
    }

    @Test
    public void testCelestialEncodesCorrectly() throws Exception {
        String text = "Safira and I went to a blacksmith to forge our sword";
        Codex codex = AlphaCodex.getInstance();
        Spell spell = new Spell(text, codex);
        String expected = "aar1yeAo0hNNLJw97Qww mSipbqxw0n55RE2QiwrsxGsv5Mw t31";

        Spell result = new CelestialTransformation().encode(spell);
        assertEquals(expected, result.getText());
    }

    @Test
    public void testCelestialEncodesCorrectlyWithCustomKey() throws Exception {
        String text = "Safira and I went to a blacksmith to forge our sword";
        Codex codex = AlphaCodex.getInstance();
        Spell spell = new Spell(text, codex);
        String expected = "Eakq8aimAu 5 1m4ti5BQawbqitkQy6 hwttHwoPs2QogrE0CoPp";

        Spell result = new CelestialTransformation("SafiraEmyra").encode(spell);
        assertEquals(expected, result.getText());
    }

    @Test
    public void testCelestialHasDecodeMethod() throws Exception {
        Method translate = celestialClass.getDeclaredMethod("decode", Spell.class);
        int methodModifiers = translate.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
    }

    @Test
    public void testCelestialDecodesCorrectly() throws Exception {
        String text = "aar1yeAo0hNNLJw97Qww mSipbqxw0n55RE2QiwrsxGsv5Mw t31";
        Codex codex = AlphaCodex.getInstance();
        Spell spell = new Spell(text, codex);
        String expected = "Safira and I went to a blacksmith to forge our sword";

        Spell result = new CelestialTransformation().decode(spell);
        assertEquals(expected, result.getText());
    }

    @Test
    public void testCelestialDecodesCorrectlyWithCustomKey() throws Exception {
        String text = "Eakq8aimAu 5 1m4ti5BQawbqitkQy6 hwttHwoPs2QogrE0CoPp";
        Codex codex = AlphaCodex.getInstance();
        Spell spell = new Spell(text, codex);
        String expected = "Safira and I went to a blacksmith to forge our sword";

        Spell result = new CelestialTransformation("SafiraEmyra").decode(spell);
        assertEquals(expected, result.getText());
    }
}

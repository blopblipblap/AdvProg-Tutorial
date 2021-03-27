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

public class AbyssalTransformationTest {
    private Class<?> abyssalClass;

    @BeforeEach
    public void setup() throws Exception {
        abyssalClass = Class.forName(
                "id.ac.ui.cs.advprog.tutorial3.facade.core.transformation.AbyssalTransformation");
    }

    @Test
    public void testAbyssalHasEncodeMethod() throws Exception {
        Method translate = abyssalClass.getDeclaredMethod("encode", Spell.class);
        int methodModifiers = translate.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
    }

    @Test
    public void testAbyssalEncodesCorrectly() throws Exception {
        String text = "Safira and I went to a blacksmith to forge our sword";
        Codex codex = AlphaCodex.getInstance();
        Spell spell = new Spell(text, codex);
        String expected = "swordSafira and I went to a blacksmith to forge our ";

        Spell result = new AbyssalTransformation().encode(spell);
        assertEquals(expected, result.getText());
    }

    @Test
    public void testAbyssalEncodesCorrectlyWithCustomKey() throws Exception {
        String text = "Safira and I went to a blacksmith to forge our sword";
        Codex codex = AlphaCodex.getInstance();
        Spell spell = new Spell(text, codex);
        String expected = "ge our swordSafira and I went to a blacksmith to for";

        Spell result = new AbyssalTransformation(12).encode(spell);
        assertEquals(expected, result.getText());
    }

    @Test
    public void testAbyssalHasDecodeMethod() throws Exception {
        Method translate = abyssalClass.getDeclaredMethod("decode", Spell.class);
        int methodModifiers = translate.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
    }

    @Test
    public void testAbyssalDecodesCorrectly() throws Exception {
        String text = "swordSafira and I went to a blacksmith to forge our ";
        Codex codex = AlphaCodex.getInstance();
        Spell spell = new Spell(text, codex);
        String expected = "Safira and I went to a blacksmith to forge our sword";

        Spell result = new AbyssalTransformation().decode(spell);
        assertEquals(expected, result.getText());
    }

    @Test
    public void testAbyssalDecodesCorrectlyWithCustomKey() throws Exception {
        String text = "ge our swordSafira and I went to a blacksmith to for";
        Codex codex = AlphaCodex.getInstance();
        Spell spell = new Spell(text, codex);
        String expected = "Safira and I went to a blacksmith to forge our sword";

        Spell result = new AbyssalTransformation(12).decode(spell);
        assertEquals(expected, result.getText());
    }
}

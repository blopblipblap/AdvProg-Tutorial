package id.ac.ui.cs.advprog.tutorial3.facade.core.misc;

import id.ac.ui.cs.advprog.tutorial3.facade.core.codex.AlphaCodex;
import id.ac.ui.cs.advprog.tutorial3.facade.core.codex.Codex;
import id.ac.ui.cs.advprog.tutorial3.facade.core.codex.RunicCodex;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CodexTranslatorTest {
    @Test
    public void testCodexHasTranslateStaticMethod() throws Exception {
        Class<?> translatorClass = Class.forName(
                "id.ac.ui.cs.advprog.tutorial3.facade.core.misc.CodexTranslator");
        Method translate = translatorClass.getDeclaredMethod("translate", Spell.class, Codex.class);
        int methodModifiers = translate.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isStatic(methodModifiers));
    }

    @Test
    public void testCodexTranslateAlphaToRunicProperly() throws Exception {
        String text = "Safira and I went to a blacksmith to forge our sword";
        Codex codex = AlphaCodex.getInstance();
        Codex targetCodex = RunicCodex.getInstance();
        Spell spell = new Spell(text, codex);
        String expected = "eJcnBJ_JZz_._DxZM_MX_J_KsJLaNdnMb_MX_cXBvx_XAB_NDXBz";

        Spell result = CodexTranslator.translate(spell, targetCodex);
        assertEquals(expected, result.getText());
    }
}

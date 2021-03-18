package id.ac.ui.cs.advprog.tutorial3.facade.core.misc;

import id.ac.ui.cs.advprog.tutorial3.facade.core.codex.Codex;
import id.ac.ui.cs.advprog.tutorial3.facade.core.codex.RunicCodex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpellTest {
    private Class<?> spellClass;
    private Spell spell;

    @Mock
    private String text;

    @Mock
    private Codex codex;

    @BeforeEach
    public void setup() throws Exception {
        text = "Safira and I went to a blacksmith to forge our sword";
        codex = RunicCodex.getInstance();
        spellClass = Spell.class;
        spell = new Spell(text, codex);
    }

    @Test
    public void testSpellIsAPublicClass() {
        int classModifiers = spellClass.getModifiers();
        assertTrue(Modifier.isPublic(classModifiers));
    }

    @Test
    public void testSpellHasGetCodexMethod() throws Exception {
        Method getCodex = spellClass.getDeclaredMethod("getCodex");
        int methodModifiers = getCodex.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
    }

    @Test
    public void testSpellGetCodexReturnsCodex() {
        assertEquals(codex, spell.getCodex());
    }

    @Test
    public void testSpellHasGetTextMethod() throws Exception {
        Method getText = spellClass.getDeclaredMethod("getText");
        int methodModifiers = getText.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
    }

    @Test
    public void testSpellGetTextReturnsText() {
        assertEquals(text, spell.getText());
    }
}

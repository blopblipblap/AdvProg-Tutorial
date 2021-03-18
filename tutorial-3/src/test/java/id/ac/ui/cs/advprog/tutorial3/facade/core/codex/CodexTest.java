package id.ac.ui.cs.advprog.tutorial3.facade.core.codex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CodexTest {
    private Class<?> codexClass;
    private Codex codex;

    @Mock
    private char[] charArr;

    @Mock
    private Map<Character, Integer> reverseIndex;

    @BeforeEach
    public void setup() throws Exception {
        charArr = new char[]{'a', 'b'};
        reverseIndex = new HashMap<>();
        reverseIndex.put('a', 0);
        reverseIndex.put('b', 1);

        codexClass = Class.forName("id.ac.ui.cs.advprog.tutorial3.facade.core.codex.Codex");
        codex = (Codex) Mockito.mock(codexClass, Mockito.CALLS_REAL_METHODS);
        ReflectionTestUtils.setField(codex, "charArr", charArr);
        ReflectionTestUtils.setField(codex, "reverseIndex", reverseIndex);
    }

    @Test
    public void testCodexIsAPublicAbstractClass() {
        int classModifiers = codexClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));
        assertTrue(Modifier.isAbstract(classModifiers));
    }

    @Test
    public void testCodexHasGetCharactersMethod() throws Exception {
        Method getCharacters = codexClass.getDeclaredMethod("getCharacters");
        int methodModifiers = getCharacters.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
    }

    @Test
    public void testCodexGetCharactersReturnsCharArr() {
        assertEquals(charArr, codex.getCharacters());
    }

    @Test
    public void testCodexHasGetCharSizeMethod() throws Exception {
        Method getCharSize = codexClass.getDeclaredMethod("getCharSize");
        int methodModifiers = getCharSize.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
    }

    @Test
    public void testCodexGetCharSizeReturnsCharArrSize() {
        assertEquals(charArr.length, codex.getCharSize());
    }

    @Test
    public void testCodexHasGetReverseIndexMethod() throws Exception {
        Method getReverseIndex = codexClass.getDeclaredMethod("getReverseIndex");
        int methodModifiers = getReverseIndex.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
    }

    @Test
    public void testCodexGetReverseIndexReturnsReverseIndex() {
        assertEquals(reverseIndex, codex.getReverseIndex());
    }

    @Test
    public void testCodexHasGetCharMethod() throws Exception {
        Method getChar = codexClass.getDeclaredMethod("getChar", int.class);
        int methodModifiers = getChar.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
    }

    @Test
    public void testCodexGetCharReturnsCorrectChar() {
        assertEquals(charArr[0], codex.getChar(0));
        assertEquals(charArr[1], codex.getChar(1));
    }

    @Test
    public void testCodexHasGetIndexMethod() throws Exception {
        Method getIndex = codexClass.getDeclaredMethod("getChar", int.class);
        int methodModifiers = getIndex.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
    }

    @Test
    public void testCodexGetIndexReturnsCorrectIndex() {
        assertEquals(reverseIndex.get('a'), codex.getIndex('a'));
        assertEquals(reverseIndex.get('b'), codex.getIndex('b'));
        assertEquals(-1, codex.getIndex('z'));
    }
}

package id.ac.ui.cs.advprog.tutorial3.facade.core.codex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class AlphaCodexTest {
    @Test
    public void testAlphaCodexIsSingleton() {
        assertSame(AlphaCodex.getInstance(), AlphaCodex.getInstance());
    }
}

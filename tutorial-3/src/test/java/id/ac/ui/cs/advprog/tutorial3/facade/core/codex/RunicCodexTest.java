package id.ac.ui.cs.advprog.tutorial3.facade.core.codex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class RunicCodexTest {
    @Test
    public void testRunicCodexIsSingleton() {
        assertSame(RunicCodex.getInstance(), RunicCodex.getInstance());
    }
}

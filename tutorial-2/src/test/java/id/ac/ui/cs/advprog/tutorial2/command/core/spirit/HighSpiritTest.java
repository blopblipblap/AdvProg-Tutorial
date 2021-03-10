package id.ac.ui.cs.advprog.tutorial2.command.core.spirit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class HighSpiritTest {

    private Class<?> highSpiritClass;

    private HighSpirit highSpirit;

    @BeforeEach
    public void setup() throws Exception {
        highSpiritClass = Class.forName("id.ac.ui.cs.advprog.tutorial2.command.core.spirit.HighSpirit");
        highSpirit = new HighSpirit();
    }

    @Test
    public void testHighSpiritIsConcreteClass() {
        assertFalse(Modifier.isAbstract(highSpiritClass.getModifiers()));
    }

    @Test
    public void testHighSpiritGetPrevStateMethod() throws Exception {
        Method getPrevState = highSpiritClass.getDeclaredMethod("getPrevState");

        assertEquals("id.ac.ui.cs.advprog.tutorial2.command.core.spirit.HighSpiritState",
                getPrevState.getGenericReturnType().getTypeName());
        assertEquals(0, getPrevState.getParameterCount());
    }

    @Test
    public void testHighSpiritGetRaceMethod() throws Exception {
        Method getRace = highSpiritClass.getDeclaredMethod("getRace");

        assertEquals("java.lang.String", getRace.getGenericReturnType().getTypeName());
        assertEquals(0, getRace.getParameterCount());
    }

    @Test
    public void testHighSpiritLifeArchivedGrowWhenAttack() {
        int sizeBefore = highSpirit.lifeArchive.size();
        highSpirit.attackStance();

        assertEquals(highSpirit.lifeArchive.size(), sizeBefore + 1);
    }

    @Test
    public void testHighSpiritLifeArchivedGrowWhenDefense() {
        int sizeBefore = highSpirit.lifeArchive.size();
        highSpirit.defenseStance();

        assertEquals(highSpirit.lifeArchive.size(), sizeBefore + 1);
    }

    @Test
    public void testHighSpiritLifeArchivedGrowWhenStealth() {
        int sizeBefore = highSpirit.lifeArchive.size();
        highSpirit.stealthStance();

        assertEquals(highSpirit.lifeArchive.size(), sizeBefore + 1);
    }

    @Test
    public void testHighSpiritLifeArchivedGrowWhenSeal() {
        int sizeBefore = highSpirit.lifeArchive.size();
        highSpirit.seal();

        assertEquals(highSpirit.lifeArchive.size(), sizeBefore + 1);
    }
}

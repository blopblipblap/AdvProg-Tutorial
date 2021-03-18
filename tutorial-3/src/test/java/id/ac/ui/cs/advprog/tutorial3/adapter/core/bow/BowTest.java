package id.ac.ui.cs.advprog.tutorial3.adapter.core.bow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// TODO: add tests
public class BowTest {
    private Class<?> bowClass;

    @BeforeEach
    public void setup() throws Exception {
        bowClass = Class.forName("id.ac.ui.cs.advprog.tutorial3.adapter.core.bow.Bow");
    }

    @Test
    public void testBowIsAPublicInterface() {
        int classModifiers = bowClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));
        assertTrue(Modifier.isInterface(classModifiers));
    }

    @Test
    public void testBowHasShootArrowAbstractMethod() throws Exception {
        Class<?>[] shootArrowArgs = new Class[1];
        shootArrowArgs[0] = boolean.class;
        Method shootArrow = bowClass.getDeclaredMethod("shootArrow", shootArrowArgs);
        int methodModifiers = shootArrow.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(1, shootArrow.getParameterCount());
    }

    @Test
    public void testBowHasGetNameAbstractMethod() throws Exception {
        Method getName = bowClass.getDeclaredMethod("getName");
        int methodModifiers = getName.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, getName.getParameterCount());
    }

    @Test
    public void testBowHasGetHolderNameAbstractMethod() throws Exception {
        Method getHolderName = bowClass.getDeclaredMethod("getHolderName");
        int methodModifiers = getHolderName.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals(0, getHolderName.getParameterCount());
    }
}

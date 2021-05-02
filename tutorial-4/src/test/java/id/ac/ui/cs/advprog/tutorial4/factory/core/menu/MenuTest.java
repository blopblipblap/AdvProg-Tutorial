package id.ac.ui.cs.advprog.tutorial4.factory.core.menu;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Flavor;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Meat;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Noodle;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Topping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    private Class<?> menuClass;

    @BeforeEach
    public void setUp() throws Exception {
        menuClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.menu.Menu");
    }

    @Test
    public void testMenuIsConcreteClass() {
        assertFalse(Modifier.isAbstract(menuClass.getModifiers()));
    }

    @Test
    public void testMenuHasNameGetter() throws Exception {
        Method getName = menuClass.getDeclaredMethod("getName");

        assertTrue(Modifier.isPublic(getName.getModifiers()));
        assertEquals(0, getName.getParameterCount());
        assertEquals("java.lang.String", getName.getGenericReturnType().getTypeName());
    }

    @Test
    public void testMenuHasGetNoodleMethod() throws Exception {
        Method getNoodle = menuClass.getDeclaredMethod("getNoodle");

        assertTrue(Modifier.isPublic(getNoodle.getModifiers()));
        assertEquals(0, getNoodle.getParameterCount());
        assertEquals(Noodle.class, getNoodle.getGenericReturnType());
    }

    @Test
    public void testMenuHasGetMeatMethod() throws Exception {
        Method getMeat = menuClass.getDeclaredMethod("getMeat");

        assertTrue(Modifier.isPublic(getMeat.getModifiers()));
        assertEquals(0, getMeat.getParameterCount());
        assertEquals(Meat.class, getMeat.getGenericReturnType());
    }

    @Test
    public void testMenuHasGetToppingMethod() throws Exception {
        Method getTopping= menuClass.getDeclaredMethod("getTopping");

        assertTrue(Modifier.isPublic(getTopping.getModifiers()));
        assertEquals(0, getTopping.getParameterCount());
        assertEquals(Topping.class, getTopping.getGenericReturnType());
    }

    @Test
    public void testMenuHasGetFlavorMethod() throws Exception {
        Method getFlavor= menuClass.getDeclaredMethod("getFlavor");

        assertTrue(Modifier.isPublic(getFlavor.getModifiers()));
        assertEquals(0, getFlavor.getParameterCount());
        assertEquals(Flavor.class, getFlavor.getGenericReturnType());
    }
}

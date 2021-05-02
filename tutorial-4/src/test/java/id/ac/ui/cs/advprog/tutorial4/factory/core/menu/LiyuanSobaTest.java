package id.ac.ui.cs.advprog.tutorial4.factory.core.menu;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Flavor;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Spicy;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Sweet;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Beef;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Meat;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Pork;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Noodle;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Ramen;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Soba;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.BoiledEgg;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Mushroom;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Topping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LiyuanSobaTest {
    private Class<?> liyuanSobaClass;

    @BeforeEach
    public void setUp() throws Exception {
        liyuanSobaClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.menu.LiyuanSoba");
    }


    @Test
    public void testLiyuanSobaIsConcreteClass() {
        assertFalse(Modifier.isAbstract(liyuanSobaClass.getModifiers()));
    }

    @Test
    public void testLiyuanSobaIsAMenu() {
        Class<?> parentClass = liyuanSobaClass.getSuperclass();

        assertEquals("id.ac.ui.cs.advprog.tutorial4.factory.core.menu.Menu",
                parentClass.getName());
    }

    @Test
    public void testLiyuanSobaGetNameReturnsMenuName() throws Exception {
        Menu sampleLiyuanSoba = new LiyuanSoba("soba lezatt");

        String name = sampleLiyuanSoba.getName();

        assertEquals(name, "soba lezatt");
    }

    @Test
    public void testLiyuanSobaGetNoodleReturnsSoba() throws Exception {
        Menu sampleLiyuanSoba = new LiyuanSoba("soba lezatt");

        Noodle noodle = sampleLiyuanSoba.getNoodle();

        assertTrue(noodle instanceof Soba);
    }

    @Test
    public void testLiyuanSobaGetMeatReturnsBeef() throws Exception {
        Menu sampleLiyuanSoba = new LiyuanSoba("soba lezatt");

        Meat meat = sampleLiyuanSoba.getMeat();

        assertTrue(meat instanceof Beef);
    }

    @Test
    public void testLiyuanSobaGetToppingReturnsMushroom() throws Exception {
        Menu sampleLiyuanSoba = new LiyuanSoba("soba lezatt");

        Topping topping = sampleLiyuanSoba.getTopping();

        assertTrue(topping instanceof Mushroom);
    }

    @Test
    public void testLiyuanSobaGetFlavorReturnsSweet() throws Exception {
        Menu sampleLiyuanSoba = new LiyuanSoba("soba lezatt");

        Flavor flavor = sampleLiyuanSoba.getFlavor();

        assertTrue(flavor instanceof Sweet);
    }
}

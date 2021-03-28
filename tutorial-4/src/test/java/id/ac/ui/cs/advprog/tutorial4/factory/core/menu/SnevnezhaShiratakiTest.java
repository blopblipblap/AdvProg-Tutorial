package id.ac.ui.cs.advprog.tutorial4.factory.core.menu;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Flavor;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Spicy;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Umami;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Fish;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Meat;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Pork;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Noodle;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Ramen;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Shirataki;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.BoiledEgg;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Flower;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Topping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SnevnezhaShiratakiTest {
    private Class<?> SnevnezhaShiratakiClass;

    @BeforeEach
    public void setUp() throws Exception {
        SnevnezhaShiratakiClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.menu.SnevnezhaShirataki");
    }


    @Test
    public void testSnevnezhaShiratakiIsConcreteClass() {
        assertFalse(Modifier.isAbstract(SnevnezhaShiratakiClass.getModifiers()));
    }

    @Test
    public void testSnevnezhaShiratakiIsAMenu() {
        Class<?> parentClass = SnevnezhaShiratakiClass.getSuperclass();

        assertEquals("id.ac.ui.cs.advprog.tutorial4.factory.core.menu.Menu",
                parentClass.getName());
    }

    @Test
    public void testSnevnezhaShiratakiGetNameReturnsMenuName() throws Exception {
        Menu sampleSnevnezhaShirataki = new SnevnezhaShirataki("shirataki lezatt");

        String name = sampleSnevnezhaShirataki.getName();

        assertEquals(name, "shirataki lezatt");
    }

    @Test
    public void testSnevnezhaShiratakiGetNoodleReturnsShirataki() throws Exception {
        Menu sampleSnevnezhaShirataki = new SnevnezhaShirataki("shirataki lezatt");

        Noodle noodle = sampleSnevnezhaShirataki.getNoodle();

        assertTrue(noodle instanceof Shirataki);
    }

    @Test
    public void testSnevnezhaShiratakiGetMeatReturnsFish() throws Exception {
        Menu sampleSnevnezhaShirataki = new SnevnezhaShirataki("shirataki lezatt");

        Meat meat = sampleSnevnezhaShirataki.getMeat();

        assertTrue(meat instanceof Fish);
    }

    @Test
    public void testSnevnezhaShiratakiGetToppingReturnsFlower() throws Exception {
        Menu sampleSnevnezhaShirataki = new SnevnezhaShirataki("shirataki lezatt");

        Topping topping = sampleSnevnezhaShirataki.getTopping();

        assertTrue(topping instanceof Flower);
    }

    @Test
    public void testSnevnezhaShiratakiGetFlavorReturnsUmami() throws Exception {
        Menu sampleSnevnezhaShirataki = new SnevnezhaShirataki("shirataki lezatt");

        Flavor flavor = sampleSnevnezhaShirataki.getFlavor();

        assertTrue(flavor instanceof Umami);
    }
}

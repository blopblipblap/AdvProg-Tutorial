package id.ac.ui.cs.advprog.tutorial4.factory.core.menu;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Flavor;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Spicy;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Meat;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Pork;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Noodle;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Ramen;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.BoiledEgg;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Topping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class InuzumaRamenTest {
    private Class<?> inuzumaRamenClass;

    @BeforeEach
    public void setUp() throws Exception {
        inuzumaRamenClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.menu.InuzumaRamen");
    }


    @Test
    public void testInuzumaRamenIsConcreteClass() {
        assertFalse(Modifier.isAbstract(inuzumaRamenClass.getModifiers()));
    }

    @Test
    public void testInuzumaRamenIsAMenu() {
        Class<?> parentClass = inuzumaRamenClass.getSuperclass();

        assertEquals("id.ac.ui.cs.advprog.tutorial4.factory.core.menu.Menu",
                parentClass.getName());
    }

    @Test
    public void testInuzumaRamenGetNameReturnsMenuName() throws Exception {
        Menu sampleInuzumaRamen = new InuzumaRamen("ramen lezatt");

        String name = sampleInuzumaRamen.getName();

        assertEquals(name, "ramen lezatt");
    }

    @Test
    public void testInuzumaRamenGetNoodleReturnsRamen() throws Exception {
        Menu sampleInuzumaRamen = new InuzumaRamen("ramen lezatt");

        Noodle noodle = sampleInuzumaRamen.getNoodle();

        assertTrue(noodle instanceof Ramen);
    }

    @Test
    public void testInuzumaRamenGetMeatReturnsPork() throws Exception {
        Menu sampleInuzumaRamen = new InuzumaRamen("ramen lezatt");

        Meat meat = sampleInuzumaRamen.getMeat();

        assertTrue(meat instanceof Pork);
    }

    @Test
    public void testInuzumaRamenGetToppingReturnsBoiledEgg() throws Exception {
        Menu sampleInuzumaRamen = new InuzumaRamen("ramen lezatt");

        Topping topping = sampleInuzumaRamen.getTopping();

        assertTrue(topping instanceof BoiledEgg);
    }

    @Test
    public void testInuzumaRamenGetFlavorReturnsSpicy() throws Exception {
        Menu sampleInuzumaRamen = new InuzumaRamen("ramen lezatt");

        Flavor flavor = sampleInuzumaRamen.getFlavor();

        assertTrue(flavor instanceof Spicy);
    }
}

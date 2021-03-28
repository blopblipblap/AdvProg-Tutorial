package id.ac.ui.cs.advprog.tutorial4.factory.core.menu;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Flavor;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Salty;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.flavor.Spicy;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Chicken;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Meat;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.meat.Pork;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Noodle;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Ramen;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.noodle.Udon;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.BoiledEgg;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Cheese;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.topping.Topping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MondoUdonTest {
    private Class<?> mondoUdonClass;

    @BeforeEach
    public void setUp() throws Exception {
        mondoUdonClass = Class.forName("id.ac.ui.cs.advprog.tutorial4.factory.core.menu.MondoUdon");
    }


    @Test
    public void testMondoUdonIsConcreteClass() {
        assertFalse(Modifier.isAbstract(mondoUdonClass.getModifiers()));
    }

    @Test
    public void testMondoUdonIsAMenu() {
        Class<?> parentClass = mondoUdonClass.getSuperclass();

        assertEquals("id.ac.ui.cs.advprog.tutorial4.factory.core.menu.Menu",
                parentClass.getName());
    }

    @Test
    public void testMondoUdonGetNameReturnsMenuName() throws Exception {
        Menu sampleMondoUdon = new MondoUdon("udon lezatt");

        String name = sampleMondoUdon.getName();

        assertEquals(name, "udon lezatt");
    }

    @Test
    public void testMondoUdonGetNoodleReturnsUdon() throws Exception {
        Menu sampleMondoUdon = new MondoUdon("udon lezatt");

        Noodle noodle = sampleMondoUdon.getNoodle();

        assertTrue(noodle instanceof Udon);
    }

    @Test
    public void testMondoUdonGetMeatReturnsPork() throws Exception {
        Menu sampleMondoUdon = new MondoUdon("udon lezatt");

        Meat meat = sampleMondoUdon.getMeat();

        assertTrue(meat instanceof Chicken);
    }

    @Test
    public void testMondoUdonGetToppingReturnsBoiledEgg() throws Exception {
        Menu sampleMondoUdon = new MondoUdon("udon lezatt");

        Topping topping = sampleMondoUdon.getTopping();

        assertTrue(topping instanceof Cheese);
    }

    @Test
    public void testMondoUdonGetFlavorReturnsSpicy() throws Exception {
        Menu sampleMondoUdon = new MondoUdon("udon lezatt");

        Flavor flavor = sampleMondoUdon.getFlavor();

        assertTrue(flavor instanceof Salty);
    }
}

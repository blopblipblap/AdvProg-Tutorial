package id.ac.ui.cs.advprog.tutorial3.adapter.core.bow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

// TODO: add tests
public class IonicBowTest {
    private Class<?> ionicBowClass;

    @BeforeEach
    public void setUp() throws Exception {
        ionicBowClass = Class.forName("id.ac.ui.cs.advprog.tutorial3.adapter.core.bow.IonicBow");
    }

    @Test
    public void testIonicBowIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(ionicBowClass.getModifiers()));
    }

    @Test
    public void testIonicBowIsABow() {
        Collection<Type> interfaces = Arrays.asList(ionicBowClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial3.adapter.core.bow.Bow")));
    }

    @Test
    public void testIonicBowOverrideShootArrowMethod() throws Exception {
        Class<?>[] shootArrowArgs = new Class[1];
        shootArrowArgs[0] = boolean.class;
        Method shootArrow = ionicBowClass.getDeclaredMethod("shootArrow", shootArrowArgs);

        assertEquals("java.lang.String",
                shootArrow.getGenericReturnType().getTypeName());
        assertEquals(1,
                shootArrow.getParameterCount());
        assertTrue(Modifier.isPublic(shootArrow.getModifiers()));
    }

    @Test
    public void testIonicBowOverrideGetNameMethod() throws Exception {
        Method getName = ionicBowClass.getDeclaredMethod("getName");

        assertEquals("java.lang.String",
                getName.getGenericReturnType().getTypeName());
        assertEquals(0,
                getName.getParameterCount());
        assertTrue(Modifier.isPublic(getName.getModifiers()));
    }

    @Test
    public void testIonicBowOverrideGetHolderMethod() throws Exception {
        Method getHolderName = ionicBowClass.getDeclaredMethod("getHolderName");

        assertEquals("java.lang.String",
                getHolderName.getGenericReturnType().getTypeName());
        assertEquals(0,
                getHolderName.getParameterCount());
        assertTrue(Modifier.isPublic(getHolderName.getModifiers()));
    }

    // TODO: buat test untuk menguji hasil dari pemanggilan method
    @Test
    public void testIonicBowShootArrowReturnValue() throws Exception {
        Bow mockIonicBow = new IonicBow("Venti");

        String normalAim = mockIonicBow.shootArrow(false);
        String aimShot = mockIonicBow.shootArrow(true);

        assertThat(normalAim).isEqualTo("Separated one atom from the enemy");
        assertThat(aimShot).isEqualTo("Arrow reacted with the enemy's protons");
    }

    @Test
    public void testIonicBowGetNameReturnValue() throws Exception {
        Bow mockIonicBow = new IonicBow("Venti");
        String weapName = mockIonicBow.getName();

        assertThat(weapName).isEqualTo("Ionic Bow");
    }

    @Test
    public void testIonicBowGetHolderReturnValue() throws Exception {
        Bow mockIonicBow = new IonicBow("Venti");
        String holderName = mockIonicBow.getHolderName();

        assertThat(holderName).isEqualTo("Venti");
    }
}

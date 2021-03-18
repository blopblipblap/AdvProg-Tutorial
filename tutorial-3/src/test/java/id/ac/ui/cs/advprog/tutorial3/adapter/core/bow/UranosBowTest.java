package id.ac.ui.cs.advprog.tutorial3.adapter.core.bow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

// TODO: add tests
public class UranosBowTest {
    private Class<?> uranosBowClass;

    @BeforeEach
    public void setUp() throws Exception {
        uranosBowClass = Class.forName("id.ac.ui.cs.advprog.tutorial3.adapter.core.bow.UranosBow");
    }

    @Test
    public void testUranosBowIsConcreteClass() {
        assertFalse(Modifier.
                isAbstract(uranosBowClass.getModifiers()));
    }

    @Test
    public void testUranosBowIsABow() {
        Collection<Type> interfaces = Arrays.asList(uranosBowClass.getInterfaces());

        assertTrue(interfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial3.adapter.core.bow.Bow")));
    }

    @Test
    public void testUranosBowOverrideShootArrowMethod() throws Exception {
        Class<?>[] shootArrowArgs = new Class[1];
        shootArrowArgs[0] = boolean.class;
        Method shootArrow = uranosBowClass.getDeclaredMethod("shootArrow", shootArrowArgs);

        assertEquals("java.lang.String",
                shootArrow.getGenericReturnType().getTypeName());
        assertEquals(1,
                shootArrow.getParameterCount());
        assertTrue(Modifier.isPublic(shootArrow.getModifiers()));
    }

    @Test
    public void testUranosBowOverrideGetNameMethod() throws Exception {
        Method getName = uranosBowClass.getDeclaredMethod("getName");

        assertEquals("java.lang.String",
                getName.getGenericReturnType().getTypeName());
        assertEquals(0,
                getName.getParameterCount());
        assertTrue(Modifier.isPublic(getName.getModifiers()));
    }

    @Test
    public void testUranosBowOverrideGetHolderMethod() throws Exception {
        Method getHolderName = uranosBowClass.getDeclaredMethod("getHolderName");

        assertEquals("java.lang.String",
                getHolderName.getGenericReturnType().getTypeName());
        assertEquals(0,
                getHolderName.getParameterCount());
        assertTrue(Modifier.isPublic(getHolderName.getModifiers()));
    }

    // TODO: buat test untuk menguji hasil dari pemanggilan method
}

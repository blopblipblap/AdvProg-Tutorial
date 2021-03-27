package id.ac.ui.cs.advprog.tutorial3.adapter.service;

import id.ac.ui.cs.advprog.tutorial3.adapter.core.bow.Bow;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.bow.IonicBow;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.bow.UranosBow;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.Spellbook;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.TheWindjedi;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.TheWindjediTest;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.SeawardPride;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.StaffOfHoumo;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.Weapon;
import id.ac.ui.cs.advprog.tutorial3.adapter.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WeaponServiceTest {
    private Class<?> weaponServiceClass;

    @Mock
    BowRepository bowRepository;

    @Mock
    SpellbookRepository spellbookRepository;

    @Spy
    WeaponRepositoryImpl weaponRepository = new WeaponRepositoryImpl();

    @Mock
    LogRepository logRepository;

    @InjectMocks
    WeaponService weaponService = new WeaponServiceImpl();

    @BeforeEach
    public void setup() throws Exception {
        weaponServiceClass = Class.forName(
                "id.ac.ui.cs.advprog.tutorial3.adapter.service.WeaponServiceImpl");
    }

    @Test
    public void testWeaponServiceHasFindAllMethod() throws Exception {
        Method findAll = weaponServiceClass.getDeclaredMethod("findAll");
        int methodModifiers = findAll.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));

        ParameterizedType pt = (ParameterizedType) findAll.getGenericReturnType();
        assertEquals(List.class, pt.getRawType());
        assertTrue(Arrays.asList(pt.getActualTypeArguments()).contains(Weapon.class));
    }

    @Test
    public void testWeaponServiceFindAllReturnCorrectWeaponAmount() {
        List<Bow> mockListBow = new ArrayList<>();
        mockListBow.add(new UranosBow("Ganyu"));
        mockListBow.add(new IonicBow("Faisal"));

        List<Spellbook> mockListSpellbook = new ArrayList<>();
        mockListSpellbook.add(new TheWindjedi("Klee"));

        weaponRepository.save(new StaffOfHoumo("Who Tao"));

        when(bowRepository.findAll()).thenReturn(mockListBow);
        when(spellbookRepository.findAll()).thenReturn(mockListSpellbook);

        assertEquals(4, weaponService.findAll().size());
        verify(weaponRepository, atLeastOnce()).findAll();
        verify(bowRepository, atLeastOnce()).findAll();
        verify(spellbookRepository, atLeastOnce()).findAll();
    }

    @Test
    public void testWeaponServiceHasGetAllLogsMethod() throws Exception {
        Method getAllLogs = weaponServiceClass.getDeclaredMethod("getAllLogs");
        int methodModifiers = getAllLogs.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));

        ParameterizedType pt = (ParameterizedType) getAllLogs.getGenericReturnType();
        assertEquals(List.class, pt.getRawType());
        assertTrue(Arrays.asList(pt.getActualTypeArguments()).contains(String.class));
    }

    @Test
    public void testWeaponServiceGetAllLogsCorrectlyImplemented() {
        weaponService.getAllLogs();
        verify(logRepository, atLeastOnce()).findAll();
    }


    @Test
    public void testWeaponServiceHasAttackWithWeaponMethod() throws Exception {
        Method attackWithWeapon = weaponServiceClass.getDeclaredMethod("attackWithWeapon", String.class, int.class);
        int methodModifiers = attackWithWeapon.getModifiers();
        assertTrue(Modifier.isPublic(methodModifiers));
    }

    @Test
    public void testWeaponServiceAttackWithWeaponCorrectlyImplemented() {
        Weapon mockWeapon = new SeawardPride("Usep");
        when(weaponRepository.findByAlias(any(String.class))).thenReturn(mockWeapon);
        weaponService.attackWithWeapon("Seaward Pride", 1);
        verify(weaponRepository, atLeastOnce()).findByAlias(any(String.class));
        verify(logRepository, atLeastOnce()).addLog(any(String.class));
        verify(weaponRepository, atLeastOnce()).save(mockWeapon);

    }
}

package id.ac.ui.cs.advprog.tutorial3.adapter.repository;

import id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.FesteringGreed;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.FullMoonPike;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.stereotype.Repository;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@Repository
public class WeaponRepositoryTest {
    private WeaponRepository weaponRepository;

    @Mock
    private Map<String, Weapon> weapons;

    private Weapon sampleWeapon;

    @BeforeEach
    public void setUp() {
        weaponRepository = new WeaponRepositoryImpl();
        weapons = new HashMap<>();
        sampleWeapon = new FesteringGreed("Kocheng");
        weapons.put(sampleWeapon.getName(), sampleWeapon);
    }

    @Test
    public void whenWeaponRepoFindAllItShouldReturnWeaponList() {
        ReflectionTestUtils.setField(weaponRepository, "weapons", weapons);
        List<Weapon> acquiredWeapons = weaponRepository.findAll();

        assertThat(acquiredWeapons).isEqualTo(new ArrayList<>(weapons.values()));
    }

    @Test
    public void whenWeaponRepoFindByAliasItShouldReturnWeaponList() {
        ReflectionTestUtils.setField(weaponRepository, "weapons", weapons);
        Weapon acquiredWeapon = weaponRepository.findByAlias(sampleWeapon.getName());

        assertThat(acquiredWeapon).isEqualTo(sampleWeapon);
    }

    @Test
    public void whenWeaponRepoSaveItShouldSaveWeapon() {
        ReflectionTestUtils.setField(weaponRepository, "weapons", weapons);
        Weapon newWeapon = new FullMoonPike("Mei Mei");
        weaponRepository.save(newWeapon);
        Weapon acquiredWeapon = weaponRepository.findByAlias(newWeapon.getName());

        assertThat(acquiredWeapon).isEqualTo(newWeapon);
    }
}

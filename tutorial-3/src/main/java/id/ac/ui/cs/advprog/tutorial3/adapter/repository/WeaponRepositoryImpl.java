package id.ac.ui.cs.advprog.tutorial3.adapter.repository;

import id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.Weapon;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// You may modify this class, but you are NOT allowed to compose (for example: autowire) another class
@Repository
public class  WeaponRepositoryImpl implements WeaponRepository {

    private Map<String, Weapon> weapons = new HashMap<>();

    @Override
    public List<Weapon> findAll() {
        return new ArrayList(weapons.values());
    }

    @Override
    public void save(Weapon weapon) {
        String weaponName = weapon.getName();
        weapons.put(weaponName, weapon);
    }

    @Override
    public Weapon findByAlias(String name) {
        return weapons.get(name);
    }
}

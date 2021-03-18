package id.ac.ui.cs.advprog.tutorial3.adapter.repository;

import id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.Weapon;

import java.util.List;

public interface WeaponRepository {

    List<Weapon> findAll();
    void save(Weapon weapon);
    Weapon findByAlias(String name);

}

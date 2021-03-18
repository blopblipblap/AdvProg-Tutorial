package id.ac.ui.cs.advprog.tutorial3.adapter.service;

import id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.Weapon;

import java.util.List;

public interface WeaponService {

    List<Weapon> findAll();
    void attackWithWeapon(String weaponName, int attackType);
    List<String> getAllLogs();

}

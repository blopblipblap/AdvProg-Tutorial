package id.ac.ui.cs.advprog.tutorial3.adapter.service;

import id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.Weapon;
import id.ac.ui.cs.advprog.tutorial3.adapter.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// TODO: Complete me. Modify this class as you see fit~
@Service
public class WeaponServiceImpl implements WeaponService {

    // feel free to include more repositories if you think it might help :)

    @Autowired
    private LogRepository logRepository;


    // TODO: implement me
    @Override
    public List<Weapon> findAll() {
        return null;
    }

    // TODO: implement me
    @Override
    public void attackWithWeapon(String weaponName, int attackType) {

    }

    // TODO: implement me
    @Override
    public List<String> getAllLogs() {
        return null;
    }
}

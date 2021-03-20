package id.ac.ui.cs.advprog.tutorial3.adapter.service;

import id.ac.ui.cs.advprog.tutorial3.adapter.core.bow.Bow;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.Spellbook;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.Weapon;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.weaponadapters.BowAdapter;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.weaponadapters.SpellbookAdapter;
import id.ac.ui.cs.advprog.tutorial3.adapter.repository.BowRepository;
import id.ac.ui.cs.advprog.tutorial3.adapter.repository.LogRepository;
import id.ac.ui.cs.advprog.tutorial3.adapter.repository.SpellbookRepository;
import id.ac.ui.cs.advprog.tutorial3.adapter.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

// TODO: Complete me. Modify this class as you see fit~
@Service
public class WeaponServiceImpl implements WeaponService {

    // feel free to include more repositories if you think it might help :)

    @Autowired
    private LogRepository logRepository;
    @Autowired
    private WeaponRepository weaponRepository;
    @Autowired
    private BowRepository bowRepository;
    @Autowired
    private SpellbookRepository spellbookRepository;

    private String attack;
    private String desc;


    // TODO: implement me
    @PostConstruct
    public void addToWeapRepo() {
        List<Bow> listBow = bowRepository.findAll();
        for (int a = 0; a < listBow.size(); a++) {
            BowAdapter bow = new BowAdapter(listBow.get(a));
            weaponRepository.save(bow);
        }
        List<Spellbook> listSpellbook = spellbookRepository.findAll();
        for (int a = 0; a < listSpellbook.size(); a++) {
            SpellbookAdapter spellbook = new SpellbookAdapter(listSpellbook.get(a));
            weaponRepository.save(spellbook);
        }
    }

    @Override
    public List<Weapon> findAll() {
        return weaponRepository.findAll();
    }

    // TODO: implement me
    @Override
    public void attackWithWeapon(String weaponName, int attackType) {
        Weapon weapon = weaponRepository.findByAlias(weaponName);
        if (attackType == 0) {
            desc = weapon.normalAttack();
            this.attack = "normal attack";
        }
        else if (attackType == 1) {
            desc = weapon.chargedAttack();
            this.attack = "charged attack";
        }
        weaponRepository.save(weapon);
        String log = String.format("%s attacked with %s (%s): %s", weapon.getHolderName(), weapon.getName(), this.attack, this.desc);
        logRepository.addLog(log);
    }

    // TODO: implement me
    @Override
    public List<String> getAllLogs() {
        return logRepository.findAll();
    }
}

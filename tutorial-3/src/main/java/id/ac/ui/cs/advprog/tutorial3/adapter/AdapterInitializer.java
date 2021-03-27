package id.ac.ui.cs.advprog.tutorial3.adapter;

import id.ac.ui.cs.advprog.tutorial3.adapter.core.bow.IonicBow;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.bow.UranosBow;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.Heatbearer;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.TheWindjedi;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.FesteringGreed;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.FullMoonPike;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.SeawardPride;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.weapon.StaffOfHoumo;
import id.ac.ui.cs.advprog.tutorial3.adapter.repository.BowRepository;
import id.ac.ui.cs.advprog.tutorial3.adapter.repository.SpellbookRepository;
import id.ac.ui.cs.advprog.tutorial3.adapter.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

// DO NOT modify this code
@Component
public class AdapterInitializer {

    @Autowired
    private BowRepository bowRepository;

    @Autowired
    private SpellbookRepository spellbookRepository;

    @Autowired
    private WeaponRepository weaponRepository;

    @PostConstruct
    public void init() {

        bowRepository.save(new IonicBow("Faisal"));
        bowRepository.save(new UranosBow("Diana"));
        spellbookRepository.save(new Heatbearer("Kipli"));
        spellbookRepository.save(new TheWindjedi("Senora"));
        weaponRepository.save(new FesteringGreed("Kocheng"));
        weaponRepository.save(new FullMoonPike("Mei Mei"));
        weaponRepository.save(new SeawardPride("Chongus"));
        weaponRepository.save(new StaffOfHoumo("Walnut"));
    }
}

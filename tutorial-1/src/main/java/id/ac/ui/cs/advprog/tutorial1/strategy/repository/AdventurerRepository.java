package id.ac.ui.cs.advprog.tutorial1.strategy.repository;

import id.ac.ui.cs.advprog.tutorial1.strategy.core.Adventurer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AdventurerRepository {

    private Map<String, Adventurer> adventurers = new HashMap<>();

    public Adventurer save(Adventurer savedAdventurer) {
        Adventurer existingAdventurer = adventurers.get(savedAdventurer.getAlias());
        if (existingAdventurer != null) {
            existingAdventurer.setAttackBehavior(savedAdventurer.getAttackBehavior());
            existingAdventurer.setDefenseBehavior(savedAdventurer.getDefenseBehavior());
            savedAdventurer = existingAdventurer;
        }
        adventurers.put(savedAdventurer.getAlias(), savedAdventurer);
        return adventurers.get(savedAdventurer.getAlias());
    }

    public Adventurer findByAlias(String alias) {
        return adventurers.get(alias);
    }

    public Iterable<Adventurer> findAll() {
        return new ArrayList<>(adventurers.values());
    }
}

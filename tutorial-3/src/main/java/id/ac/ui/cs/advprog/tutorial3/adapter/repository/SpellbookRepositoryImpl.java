package id.ac.ui.cs.advprog.tutorial3.adapter.repository;

import id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.Spellbook;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// You may modify this class, but you are NOT allowed to compose (for example: autowire) another class
@Repository
public class SpellbookRepositoryImpl implements SpellbookRepository {

    private Map<String, Spellbook> spellbooks = new HashMap<>();

    @Override
    public List<Spellbook> findAll() {
        return new ArrayList(spellbooks.values());
    }

    @Override
    public void save(Spellbook spellbook) {

        String spellbookName = spellbook.getName();
        spellbooks.put(spellbookName, spellbook);

    }

    @Override
    public Spellbook findByAlias(String name) {
        return spellbooks.get(name);
    }
}

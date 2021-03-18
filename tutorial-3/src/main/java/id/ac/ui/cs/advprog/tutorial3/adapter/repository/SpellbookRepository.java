package id.ac.ui.cs.advprog.tutorial3.adapter.repository;

import id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.Spellbook;

import java.util.List;

public interface SpellbookRepository {

    List<Spellbook> findAll();
    void save(Spellbook spellbook);
    Spellbook findByAlias(String name);
}

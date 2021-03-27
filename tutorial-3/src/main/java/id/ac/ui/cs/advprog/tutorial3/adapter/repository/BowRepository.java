package id.ac.ui.cs.advprog.tutorial3.adapter.repository;

import id.ac.ui.cs.advprog.tutorial3.adapter.core.bow.Bow;

import java.util.List;

public interface BowRepository {

    List<Bow> findAll();
    void save(Bow weapon);
    Bow findByAlias(String name);
}

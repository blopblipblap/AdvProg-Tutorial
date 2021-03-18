package id.ac.ui.cs.advprog.tutorial3.adapter.repository;

import id.ac.ui.cs.advprog.tutorial3.adapter.core.bow.Bow;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// You may modify this class, but you are NOT allowed to compose (for example: autowire) another class
@Repository
public class BowRepositoryImpl implements BowRepository {

    private Map<String, Bow> bows = new HashMap<>();

    @Override
    public List<Bow> findAll() {
        return new ArrayList(bows.values());
    }

    @Override
    public void save(Bow bow) {

        String bowName = bow.getName();

        bows.put(bowName, bow);
    }

    @Override
    public Bow findByAlias(String name) {

        return bows.get(name);
    }
}

package id.ac.ui.cs.advprog.tutorial2.template.service;

import id.ac.ui.cs.advprog.tutorial2.template.core.Saber;
import id.ac.ui.cs.advprog.tutorial2.template.core.Lancer;
import id.ac.ui.cs.advprog.tutorial2.template.core.Archer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestServiceImpl implements QuestService {

    private Saber saber;
    private Archer archer;
    private Lancer lancer;

    public QuestServiceImpl() {
        saber = new Saber();
        archer = new Archer();
        lancer = new Lancer();
        seed();
    }

    private void seed() {
        Saber a = new Saber();
        Archer b = new Archer();
        Lancer c = new Lancer();
    }

    @Override
    public Iterable<Saber> getSaber() {
        return saber.attackPattern();
    }

    @Override
    public Iterable<Archer> getArcher() {
        return archer.attackPattern();
    }

    @Override
    public Iterable<Lancer> getLancer() {
        return lancer.attackPattern();
    }
}
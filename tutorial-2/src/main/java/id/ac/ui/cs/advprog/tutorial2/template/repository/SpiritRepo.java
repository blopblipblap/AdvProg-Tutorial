package id.ac.ui.cs.advprog.tutorial2.template.repository;

import id.ac.ui.cs.advprog.tutorial2.template.core.Saber;
import id.ac.ui.cs.advprog.tutorial2.template.core.Lancer;
import id.ac.ui.cs.advprog.tutorial2.template.core.Archer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpiritRepo {
    private Saber saber;
    private Archer archer;
    private Lancer lancer;

    public List<Saber> attackPatternSaber() { return saber.attackPattern(); }

    public List<Archer> attackPatternArcher() { return archer.attackPattern(); }

    public List<Lancer> attackPatternLancer() { return lancer.attackPattern(); }

}
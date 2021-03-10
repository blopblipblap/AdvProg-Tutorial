package id.ac.ui.cs.advprog.tutorial2.template.service;

import id.ac.ui.cs.advprog.tutorial2.template.core.Saber;
import id.ac.ui.cs.advprog.tutorial2.template.core.Archer;
import id.ac.ui.cs.advprog.tutorial2.template.core.Lancer;

public interface QuestService {
    Iterable<Saber> getSaber();
    Iterable<Archer> getArcher();
    Iterable<Lancer> getLancer();
}

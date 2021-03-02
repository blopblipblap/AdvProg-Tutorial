package id.ac.ui.cs.advprog.tutorial1.observer.service;

import id.ac.ui.cs.advprog.tutorial1.observer.core.Adventurer;
import id.ac.ui.cs.advprog.tutorial1.observer.core.Quest;

import java.util.List;

public interface GuildService {
    void addQuest(Quest quest);
    List<Adventurer> getAdventurers();
}

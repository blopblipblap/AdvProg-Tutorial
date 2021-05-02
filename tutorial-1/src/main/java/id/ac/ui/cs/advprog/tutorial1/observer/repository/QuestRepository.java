package id.ac.ui.cs.advprog.tutorial1.observer.repository;

import id.ac.ui.cs.advprog.tutorial1.observer.core.Quest;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class QuestRepository {

    private Map<String, Quest> quests = new HashMap<>();

    public Map<String, Quest> getQuests() {
        return quests;
    }

    public Quest save(Quest savedQuest) {
        Quest existingQuest = quests.get(savedQuest.getTitle());
        if (existingQuest == null) {
            quests.put(savedQuest.getTitle(), savedQuest);
            return savedQuest;
        } else {
            return null;
        }
    }
}

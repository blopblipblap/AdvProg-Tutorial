package id.ac.ui.cs.advprog.tutorial1.observer.service;

import id.ac.ui.cs.advprog.tutorial1.observer.core.*;
import id.ac.ui.cs.advprog.tutorial1.observer.repository.QuestRepository;
import id.ac.ui.cs.advprog.tutorial1.observer.core.Adventurer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuildServiceImpl implements GuildService {
    private final QuestRepository questRepository;
    private final Guild guild;
    private final Adventurer agileAdventurer;
    private final Adventurer knightAdventurer;
    private final Adventurer mysticAdventurer;

    public GuildServiceImpl(QuestRepository questRepository) {
        this.questRepository = questRepository;
        this.guild = new Guild();
        //ToDO: Complete Me
        this.agileAdventurer = new AgileAdventurer(guild);
        guild.add(agileAdventurer);
        this.knightAdventurer = new KnightAdventurer(guild);
        guild.add(knightAdventurer);
        this.mysticAdventurer = new MysticAdventurer(guild);
        guild.add(mysticAdventurer);
    }

    //ToDo: Complete Me

    @Override
    public void addQuest(Quest quest) {
        this.guild.addQuest(quest);
        questRepository.save(quest);
    }

    @Override
    public List<Adventurer> getAdventurers() {
        return this.guild.getAdventurers();
    }
}

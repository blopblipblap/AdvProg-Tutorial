package id.ac.ui.cs.advprog.tutorial3.adapter.repository;

import id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.Heatbearer;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.TheWindjedi;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.spellbook.Spellbook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.stereotype.Repository;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@Repository
public class SpellbookRepositoryTest {
    private SpellbookRepository spellbookRepository;

    @Mock
    private Map<String, Spellbook> spellbooks;

    private Spellbook sampleSpellbook;

    @BeforeEach
    public void setUp() {
        spellbookRepository = new SpellbookRepositoryImpl();
        spellbooks = new HashMap<>();
        sampleSpellbook = new Heatbearer("Kocheng");
        spellbooks.put(sampleSpellbook.getName(), sampleSpellbook);
    }

    @Test
    public void whenSpellbookRepoFindAllItShouldReturnSpellbookList() {
        ReflectionTestUtils.setField(spellbookRepository, "spellbooks", spellbooks);
        List<Spellbook> acquiredSpellbooks = spellbookRepository.findAll();

        assertThat(acquiredSpellbooks).isEqualTo(new ArrayList<>(spellbooks.values()));
    }

    @Test
    public void whenSpellbookRepoFindByAliasItShouldReturnSpellbookList() {
        ReflectionTestUtils.setField(spellbookRepository, "spellbooks", spellbooks);
        Spellbook acquiredSpellbook = spellbookRepository.findByAlias(sampleSpellbook.getName());

        assertThat(acquiredSpellbook).isEqualTo(sampleSpellbook);
    }

    @Test
    public void whenSpellbookRepoSaveItShouldSaveSpellbook() {
        ReflectionTestUtils.setField(spellbookRepository, "spellbooks", spellbooks);
        Spellbook newSpellbook = new TheWindjedi("Mei Mei");
        spellbookRepository.save(newSpellbook);
        Spellbook acquiredSpellbook = spellbookRepository.findByAlias(newSpellbook.getName());

        assertThat(acquiredSpellbook).isEqualTo(newSpellbook);
    }
}

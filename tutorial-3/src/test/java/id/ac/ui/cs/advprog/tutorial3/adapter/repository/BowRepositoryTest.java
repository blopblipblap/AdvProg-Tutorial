package id.ac.ui.cs.advprog.tutorial3.adapter.repository;

import id.ac.ui.cs.advprog.tutorial3.adapter.core.bow.IonicBow;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.bow.UranosBow;
import id.ac.ui.cs.advprog.tutorial3.adapter.core.bow.Bow;
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
public class BowRepositoryTest {
    private BowRepository bowRepository;

    @Mock
    private Map<String, Bow> bows;

    private Bow sampleBow;

    @BeforeEach
    public void setUp() {
        bowRepository = new BowRepositoryImpl();
        bows = new HashMap<>();
        sampleBow = new IonicBow("Kocheng");
        bows.put(sampleBow.getName(), sampleBow);
    }

    @Test
    public void whenBowRepoFindAllItShouldReturnBowList() {
        ReflectionTestUtils.setField(bowRepository, "bows", bows);
        List<Bow> acquiredBows = bowRepository.findAll();

        assertThat(acquiredBows).isEqualTo(new ArrayList<>(bows.values()));
    }

    @Test
    public void whenBowRepoFindByAliasItShouldReturnBowList() {
        ReflectionTestUtils.setField(bowRepository, "bows", bows);
        Bow acquiredBow = bowRepository.findByAlias(sampleBow.getName());

        assertThat(acquiredBow).isEqualTo(sampleBow);
    }

    @Test
    public void whenBowRepoSaveItShouldSaveBow() {
        ReflectionTestUtils.setField(bowRepository, "bows", bows);
        Bow newBow = new UranosBow("Mei Mei");
        bowRepository.save(newBow);
        Bow acquiredBow = bowRepository.findByAlias(newBow.getName());

        assertThat(acquiredBow).isEqualTo(newBow);
    }
}

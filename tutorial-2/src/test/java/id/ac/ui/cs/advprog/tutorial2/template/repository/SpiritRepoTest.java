package id.ac.ui.cs.advprog.tutorial2.template.repository;

import id.ac.ui.cs.advprog.tutorial2.template.core.Archer;
import id.ac.ui.cs.advprog.tutorial2.template.core.Lancer;
import id.ac.ui.cs.advprog.tutorial2.template.core.Saber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.stereotype.Repository;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;

@Repository
public class SpiritRepoTest {

    private SpiritRepo spiritRepo;

    @Mock
    private Saber saber;

    @Mock
    private Archer archer;

    @Mock
    private Lancer lancer;

    @BeforeEach
    public void setUp() {
        spiritRepo = new SpiritRepo();
        saber = new Saber();
        lancer = new Lancer();
        archer = new Archer();
    }

    @Test
    public void whenSpiritRepoAttackPatternSaberItShouldReturnSaberAttackPattern() {
        ReflectionTestUtils.setField(spiritRepo, "saber", new Saber());
        Iterable<Saber> calledSaber = spiritRepo.attackPatternSaber();

        assertThat(calledSaber).isEqualTo(saber.attackPattern());
    }

    @Test
    public void whenSpiritRepoAttackPatternLancerItShouldReturnLancerAttackPattern() {
        ReflectionTestUtils.setField(spiritRepo, "lancer", new Lancer());
        Iterable<Lancer> calledLancer = spiritRepo.attackPatternLancer();

        assertThat(calledLancer).isEqualTo(lancer.attackPattern());
    }

    @Test
    public void whenSpiritRepoAttackPatternArcherItShouldReturnArcherAttackPattern() {
        ReflectionTestUtils.setField(spiritRepo, "archer", new Archer());
        Iterable<Archer> calledArcher = spiritRepo.attackPatternArcher();

        assertThat(calledArcher).isEqualTo(archer.attackPattern());
    }
}
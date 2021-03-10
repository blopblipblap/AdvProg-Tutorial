package id.ac.ui.cs.advprog.tutorial2.template.service;

import id.ac.ui.cs.advprog.tutorial2.template.core.Archer;
import id.ac.ui.cs.advprog.tutorial2.template.core.Lancer;
import id.ac.ui.cs.advprog.tutorial2.template.core.Saber;
import id.ac.ui.cs.advprog.tutorial2.template.repository.SpiritRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class QuestServiceImplTest {

    @Mock
    private SpiritRepo spiritRepo;

    @InjectMocks
    private QuestServiceImpl questService;

    @Test
    public void whenGetSaberIsCalledItShouldReturnSaberAttackPattern() {
        Saber saber = new Saber();

        Iterable<Saber> calledSaber = questService.getSaber();

        assertThat(calledSaber).isEqualTo(saber.attackPattern());
    }

    @Test
    public void whenGetLancerIsCalledItShouldReturnLancerAttackPattern() {
        Lancer lancer = new Lancer();

        Iterable<Lancer> calledLancer = questService.getLancer();

        assertThat(calledLancer).isEqualTo(lancer.attackPattern());
    }

    @Test
    public void whenGetArcherIsCalledItShouldReturnArcherAttackPattern() {
        Archer archer = new Archer();

        Iterable<Archer> calledArcher = questService.getArcher();

        assertThat(calledArcher).isEqualTo(archer.attackPattern());
    }
}

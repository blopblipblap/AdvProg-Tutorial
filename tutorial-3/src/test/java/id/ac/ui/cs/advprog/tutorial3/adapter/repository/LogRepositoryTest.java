package id.ac.ui.cs.advprog.tutorial3.adapter.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.stereotype.Repository;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Repository
public class LogRepositoryTest {
    private LogRepository logRepository;

    @Mock
    private List<String> logs;

    @BeforeEach
    public void setUp() {
        logRepository = new LogRepositoryImpl();
        logs = new ArrayList<>();
        logs.add("Affan attacks with Levitation: Swoosh!");
    }

    @Test
    public void whenLogRepoFindAllItShouldReturnLogList() {
        ReflectionTestUtils.setField(logRepository, "logs", logs);
        List<String> acquiredLogs = logRepository.findAll();

        assertThat(acquiredLogs).isEqualTo(logs);
    }

    @Test
    public void whenLogRepoAddLogItShouldSaveLog() {
        ReflectionTestUtils.setField(logRepository, "logs", logs);
        String newLog = "Safira defends with Ice Shield: [[insert cracked sound]]";
        logRepository.addLog(newLog);
        List<String> acquiredLogs = logRepository.findAll();

        assertThat(acquiredLogs).isEqualTo(logs);
        assertThat(logs.get(1)).isEqualTo(newLog);
    }
}

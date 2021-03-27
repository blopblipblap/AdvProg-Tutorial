package id.ac.ui.cs.advprog.tutorial3.adapter.repository;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// You may modify this class, but you are NOT allowed to compose (for example: autowire) another class
@Repository
public class LogRepositoryImpl implements LogRepository {

    private List<String> logs = new ArrayList<>();

    @Override
    public List<String> findAll() {
        return logs;
    }

    @Override
    public void addLog(String newLog) {
        logs.add(newLog);
    }
}



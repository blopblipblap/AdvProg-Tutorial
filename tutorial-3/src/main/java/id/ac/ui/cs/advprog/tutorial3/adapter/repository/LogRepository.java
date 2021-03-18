package id.ac.ui.cs.advprog.tutorial3.adapter.repository;

import java.util.List;

public interface LogRepository {

    List<String> findAll();
    void addLog(String log);
}

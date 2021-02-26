package id.ac.ui.cs.tutorial0.service;

import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class AdventurerCalculatorServiceImpl implements AdventurerCalculatorService {

    @Override
    public int countPowerPotensialFromBirthYear(int birthYear) {
        int rawAge = getRawAge(birthYear);
        if (rawAge<30) {
            return rawAge*2000;
        } else if (rawAge <50) {
            return rawAge*2250;
        } else {
            return rawAge*5000;
        }
    }

    private int getRawAge(int birthYear) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear-birthYear;
    }
}

package com.example.ProjectSpringManager10;

import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultsProcessor {
    private List<Athlete> athletes = new ArrayList<>();

    public void loadResults(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 4) {
                    String name = parts[0].split(" ")[0];
                    String surname = parts[0].split(" ")[1];
                    athletes.add(new Athlete(name, surname, parts[1], parts[2], parts[3]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Athlete> getTopAthletes(String distance, String gender, int n) {
        return athletes.stream()
                .filter(a -> a.getDistance().equals(distance) && a.getGender().equals(gender))
                .sorted((a1, a2) -> compareTimes(a1.getTime(), a2.getTime()))
                .limit(n)
                .collect(Collectors.toList());
    }

    private int compareTimes(String time1, String time2) {
        String[] parts1 = time1.split(":");
        String[] parts2 = time2.split(":");
        int totalSeconds1 = Integer.parseInt(parts1[0]) * 60 + Integer.parseInt(parts1[1]);
        int totalSeconds2 = Integer.parseInt(parts2[0]) * 60 + Integer.parseInt(parts2[1]);
        return Integer.compare(totalSeconds1, totalSeconds2);
    }


}


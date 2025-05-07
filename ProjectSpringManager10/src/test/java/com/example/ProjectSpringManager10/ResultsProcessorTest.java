package com.example.ProjectSpringManager10;

import com.example.ProjectSpringManager10.Athlete;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultsProcessorTest {
    private ResultsProcessor resultsProcessor;

    @BeforeEach
    public void setUp() {
        resultsProcessor = new ResultsProcessor();
    }

    @Test
    public void testLoadResults() throws IOException {
        // ������� ��������� CSV ����
        File tempFile = File.createTempFile("results", ".csv");
        tempFile.deleteOnExit(); // ������� ���� ��� ���������� ���������
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("���� ������, �, 10 ��, 55:20\n");
            writer.write("���� ������, �, 10 ��, 50:15\n");
            // ���������, ��� ������ ����� ���������� ������
        }

        // ��������� ����������
        resultsProcessor.loadResults(tempFile.getAbsolutePath());

        // ��������� ���������� ����������� �����������
        List<Athlete> athletes = resultsProcessor.getTopAthletes("10 ��", "�", 10);
        System.out.println("Number of athletes: " + athletes.size());
        assertEquals(2, athletes.size());


        assertEquals("���� ������", athletes.get(0).getLastName());
        assertEquals("���� ������", athletes.get(1).getLastName());
    }
}


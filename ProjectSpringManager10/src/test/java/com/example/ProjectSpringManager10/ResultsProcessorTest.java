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
        // Создаем временный CSV файл
        File tempFile = File.createTempFile("results", ".csv");
        tempFile.deleteOnExit(); // Удаляем файл при завершении программы
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write("Иван Иванов, М, 10 км, 55:20\n");
            writer.write("Петр Петров, М, 10 км, 50:15\n");
            // Убедитесь, что строки имеют правильный формат
        }

        // Загружаем результаты
        resultsProcessor.loadResults(tempFile.getAbsolutePath());

        // Проверяем количество загруженных результатов
        List<Athlete> athletes = resultsProcessor.getTopAthletes("10 км", "М", 10);
        System.out.println("Number of athletes: " + athletes.size());
        assertEquals(2, athletes.size());


        assertEquals("Иван Иванов", athletes.get(0).getLastName());
        assertEquals("Петр Петров", athletes.get(1).getLastName());
    }
}


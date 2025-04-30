package com.example.ProjectSpringManager10;

import org.springframework.web.bind.annotation.*; // Импортируем все аннотации из Spring Web
import java.util.List;

@RestController
@RequestMapping("/api/results") // Можно добавить базовый путь для всех методов контроллера
public class ResultsController {
    private final ResultsProcessor resultsProcessor;

    public ResultsController(ResultsProcessor resultsProcessor) {
        this.resultsProcessor = resultsProcessor;
    }

    @PostMapping("/load")
    public void loadResults(@RequestParam String filePath) {
        resultsProcessor.loadResults(filePath);
    }

    @GetMapping("/top")
    public List<Athlete> getTopAthletes(@RequestParam String distance, @RequestParam String gender, @RequestParam int n) {
        return resultsProcessor.getTopAthletes(distance, gender, n);
    }
}



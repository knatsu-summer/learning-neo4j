package dev.kiyoshi.spring_boot_neo4j.controllers;

import dev.kiyoshi.spring_boot_neo4j.models.*;
import dev.kiyoshi.spring_boot_neo4j.services.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lessons")
public class LessonController {
    private final LessonService LessonService;

    public LessonController(LessonService LessonService) {
        this.LessonService = LessonService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Lesson>> LessonIndex() {
        return new ResponseEntity<>(LessonService.getALLLesson(), HttpStatus.OK);
    }
}
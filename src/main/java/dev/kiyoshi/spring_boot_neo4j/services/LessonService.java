package dev.kiyoshi.spring_boot_neo4j.services;

import dev.kiyoshi.spring_boot_neo4j.models.*;
import dev.kiyoshi.spring_boot_neo4j.repositories.*;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {
    private final LessonRepository LessonRepository;

    public LessonService(LessonRepository LessonRepository) {
        this.LessonRepository = LessonRepository;
    }

    public List<Lesson> getALLLesson() {
        return LessonRepository.findAll();
    }

    public List<Lesson> getALLLessonByCourseIdentifier(String identifier) {
        return LessonRepository.findLessonByCourseIdentifier(identifier);
    }
}
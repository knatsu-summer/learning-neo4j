package dev.kiyoshi.spring_boot_neo4j.services;

import dev.kiyoshi.spring_boot_neo4j.models.*;
import dev.kiyoshi.spring_boot_neo4j.repositories.CourseRepository;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getALLCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseByIdentifier(String indentifier) {
        return courseRepository.findCourseByIdentifier(indentifier)
            .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
    }
}

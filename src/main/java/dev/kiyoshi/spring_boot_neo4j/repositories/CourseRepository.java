package dev.kiyoshi.spring_boot_neo4j.repositories;

import dev.kiyoshi.spring_boot_neo4j.models.Course;

import java.util.Optional;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CourseRepository extends Neo4jRepository<Course, Long> {
    Optional<Course> findCourseByIdentifier(String identifier);
}

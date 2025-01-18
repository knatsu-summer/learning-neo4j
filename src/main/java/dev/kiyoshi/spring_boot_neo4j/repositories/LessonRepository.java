package dev.kiyoshi.spring_boot_neo4j.repositories;

import dev.kiyoshi.spring_boot_neo4j.models.Lesson;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import org.springframework.data.neo4j.repository.query.Query;


public interface LessonRepository extends Neo4jRepository<Lesson, Long> {
    @Query("MATCH (:Course {identifier: $identifier})<-[:BELONGS_TO]-(lessons:Lesson) RETURN lessons")
    List<Lesson> findLessonByCourseIdentifier(String identifier);
}

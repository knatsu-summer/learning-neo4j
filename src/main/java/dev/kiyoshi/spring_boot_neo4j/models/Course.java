package dev.kiyoshi.spring_boot_neo4j.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class Course {
    @Id @GeneratedValue
    private Long id;
    private String identifier;
    private String title;
    private String teacher;
    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.INCOMING)
    private List<Lesson> lessons = new ArrayList<>();

    public Course() {

    }

    public String getIdentifiler() {
        return identifier;
    }

    public String getTitle() {
        return title;
    }

    public String getTeacher() {
        return teacher;
    }

    public String setIdentifier(String identifier) {
        return this.identifier = identifier;
    }

    public String setTitle(String title) {
        return this.title = title;
    }

    public String setTeacher(String teacher) {
        return this.teacher = teacher;
    }

}


package dev.kiyoshi.spring_boot_neo4j.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Course {
    @Id @GeneratedValue
    private Long id;
    private String identifier;
    private String title;
    private String teacher;

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

    public String setIdentifier(String identifiler) {
        return this.identifier = identifier;
    }

    public String setTitle(String title) {
        return this.title = title;
    }

    public String setTeacher(String teacher) {
        return this.teacher = teacher;
    }

}


package dev.kiyoshi.spring_boot_neo4j.object;

import java.util.ArrayList;
import java.util.List;

import dev.kiyoshi.spring_boot_neo4j.models.Lesson;


public class CourseDTO {
    private String identifier;
    private String title;
    private String teacher;
    private List<Lesson> lessons = new ArrayList<>();

    public CourseDTO(String identifier, String title, String teacher) {
        this.identifier = identifier;
        this.title = title;
        this.teacher = teacher;
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

    public List<Lesson> getLessons() {
        return lessons;
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

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}

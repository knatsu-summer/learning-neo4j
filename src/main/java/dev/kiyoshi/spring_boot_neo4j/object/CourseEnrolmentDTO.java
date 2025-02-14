package dev.kiyoshi.spring_boot_neo4j.object;

import dev.kiyoshi.spring_boot_neo4j.models.Course;

public class CourseEnrolmentDTO {
    private String name;
    private String username;
    private Course course;

    public CourseEnrolmentDTO(String identifier, String title, Course teacher) {
        this.name = identifier;
        this.username = title;
        this.course = teacher;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}

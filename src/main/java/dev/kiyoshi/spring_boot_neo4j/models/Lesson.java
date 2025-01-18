package dev.kiyoshi.spring_boot_neo4j.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;

public class Lesson {
    @Id @GeneratedValue
    private Long id;
    private String identifier;
    private String title;

    public Lesson() {

    }

    public String getIdentifiler() {
        return identifier;
    }

    public String getTitle() {
        return title;
    }

    public String setIdentifier(String identifiler) {
        return this.identifier = identifier;
    }

    public String setTitle(String title) {
        return this.title = title;
    }
}

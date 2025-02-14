package dev.kiyoshi.spring_boot_neo4j.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.kiyoshi.spring_boot_neo4j.models.Course;
import dev.kiyoshi.spring_boot_neo4j.queryresults.CourseEnrolmentQueryResult;
import dev.kiyoshi.spring_boot_neo4j.repositories.CourseRepository;
import dev.kiyoshi.spring_boot_neo4j.repositories.UserRepository;

@Service
public class CourseEnrolmentService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public CourseEnrolmentService(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    public boolean getEnrolmentStatus(String username, String identifiler) {
        return userRepository.findEnrolmentStatus(username, identifiler);
    }

    public CourseEnrolmentQueryResult enrollIn(String username, String identifiler) {
        // TODO: make sure that the user has not been enrolled in the course already.
        System.out.println("username:" + username);
        System.out.println("courseIdentifier:" + identifiler);
        return userRepository.createEnrolmentRelationship(username, identifiler);
    }

    public List<Course> getAllEnrolledCoursesByUsername(String username) {
        return courseRepository.findAllEnrolledCoursesByUsername(username);
    }
}

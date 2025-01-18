
package dev.kiyoshi.spring_boot_neo4j.controllers;

import dev.kiyoshi.spring_boot_neo4j.models.*;
import dev.kiyoshi.spring_boot_neo4j.object.CourseDTO;
import dev.kiyoshi.spring_boot_neo4j.services.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    private final LessonService lessonService;

    public CourseController(CourseService courseService, LessonService lessonService) {
        this.courseService = courseService;
        this.lessonService = lessonService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Course>> courseIndex() {
        return new ResponseEntity<>(courseService.getALLCourses(), HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<List<CourseDTO>> courseIndexTest() {
        List<Course> courses = courseService.getALLCourses();

        List<CourseDTO> responseCourses = courses.stream().map(
            (course) -> {
                CourseDTO responseCourse = new CourseDTO(course.getIdentifiler(), course.getTitle(), course.getTeacher());
                responseCourse.setLessons(lessonService.getALLLessonByCourseIdentifier(course.getIdentifiler()));

                return responseCourse;
            }
        ).collect(Collectors.toList());

        return new ResponseEntity<>(responseCourses, HttpStatus.OK);
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<CourseDTO> getCourseIndex(@PathVariable String identifier) {
        Course course = courseService.getCourseByIdentifier(identifier);

        CourseDTO responseCourse = new CourseDTO(course.getIdentifiler(), course.getTitle(), course.getTeacher());
        responseCourse.setLessons(lessonService.getALLLessonByCourseIdentifier(course.getIdentifiler()));
        
        return new ResponseEntity<>(responseCourse, HttpStatus.OK);
    }
}

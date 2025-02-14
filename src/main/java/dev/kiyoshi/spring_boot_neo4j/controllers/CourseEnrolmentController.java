package dev.kiyoshi.spring_boot_neo4j.controllers;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.kiyoshi.spring_boot_neo4j.object.CourseEnrolmentDTO;
import dev.kiyoshi.spring_boot_neo4j.queryresults.CourseEnrolmentQueryResult;
import dev.kiyoshi.spring_boot_neo4j.requests.CourseEnrolmentRequest;
import dev.kiyoshi.spring_boot_neo4j.services.CourseEnrolmentService;
import dev.kiyoshi.spring_boot_neo4j.services.LessonService;

@RestController
@RequestMapping("/api/v1/enrollments")
public class CourseEnrolmentController {
    private final CourseEnrolmentService courseEnrolmentService;
    private final LessonService lessonService;

    public CourseEnrolmentController(CourseEnrolmentService courseEnrolmentService, LessonService lessonService) {
        this.courseEnrolmentService = courseEnrolmentService;
        this.lessonService = lessonService;
    }


    @PostMapping("/")
    public ResponseEntity<CourseEnrolmentDTO> enrollin(@RequestBody CourseEnrolmentRequest request, Principal principal) {
        System.out.println("testtttt");
        System.out.println("request:" + request.getIdentifiler());
        CourseEnrolmentQueryResult enrolmentQueryResult = courseEnrolmentService.enrollIn(principal.getName(), request.getIdentifiler());
        System.out.println("request:" + request.getIdentifiler());

        CourseEnrolmentDTO responseEnrolment = new CourseEnrolmentDTO(
                enrolmentQueryResult.getUser().getUsername(),
                enrolmentQueryResult.getUser().getName(),
                enrolmentQueryResult.getCourse()
        );


        return new ResponseEntity<>(responseEnrolment, HttpStatus.OK);

    }
}

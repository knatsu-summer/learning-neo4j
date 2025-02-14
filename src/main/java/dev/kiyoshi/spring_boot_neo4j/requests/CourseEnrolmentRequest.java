package dev.kiyoshi.spring_boot_neo4j.requests;

public class CourseEnrolmentRequest {
    private String identifiler;

    public CourseEnrolmentRequest(String identifiler) {
        this.identifiler = identifiler;
    }

    public String getIdentifiler() {
        return identifiler;
    }

    public void setIdentifiler(String identifiler) {
        this.identifiler = identifiler;
    }
}
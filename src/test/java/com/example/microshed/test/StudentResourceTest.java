package com.example.microshed.test;

import com.example.model.Student;
import org.junit.jupiter.api.Test;
import org.microshed.testing.jupiter.MicroShedTest;
import org.microshed.testing.testcontainers.ApplicationContainer;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import javax.ws.rs.core.Response;

@MicroShedTest
public class StudentResourceTest {

    public static ApplicationContainer app = new ApplicationContainer()
            .withAppContextRoot("/students");

    @Test
    public void testGetAllStudents() {
        given()
            .when().get("/students")
            .then()
            .statusCode(200)
            .body("size()", greaterThan(0));
    }

    @Test
    public void testAddStudent() {
        Student student = new Student("Test", "Student", 21, "Address", "City", "State", "Zip");
        given()
            .contentType("application/json")
            .body(student)
            .when().post("/students")
            .then()
            .statusCode(Response.Status.CREATED.getStatusCode());
    }
}
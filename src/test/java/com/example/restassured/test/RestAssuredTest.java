package com.example.restassured.test;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public void testGetAllStudents() {
        when().get("/students")
            .then()
            .statusCode(200)
            .body("size()", greaterThan(0));
    }

    @Test
    public void testAddStudent() {
        String newStudent = "{\"firstName\":\"Test\", \"lastName\":\"Student\", \"age\":21, \"address\":\"Address\", \"city\":\"City\", \"state\":\"State\", \"zipcode\":\"Zip\"}";

        given()
            .contentType("application/json")
            .body(newStudent)
            .when().post("/students")
            .then()
            .statusCode(201);
    }

    @Test
    public void testUpdateStudent() {
        String updatedStudent = "{\"firstName\":\"Updated\", \"lastName\":\"Student\", \"age\":22, \"address\":\"New Address\", \"city\":\"New City\", \"state\":\"New State\", \"zipcode\":\"New Zip\"}";

        given()
            .contentType("application/json")
            .body(updatedStudent)
            .when().put("/students/1")
            .then()
            .statusCode(200);
    }

    @Test
    public void testDeleteStudent() {
        when().delete("/students/1")
            .then()
            .statusCode(204);
    }
}
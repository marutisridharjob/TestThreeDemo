
package com.example.controller;

import com.example.model.Student;
import com.example.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentController {

    @Inject
    private StudentService studentService;

    @GET
    public Response getStudents(@QueryParam("firstName") String firstName, 
                                @QueryParam("lastName") String lastName,
                                @QueryParam("city") String city) {
        List<Student> students = studentService.getStudents(firstName, lastName, city);
        return Response.ok(students).build();
    }

    @GET
    @Path("/{id}")
    public Response getStudentById(@PathParam("id") int id) {
        Student student = studentService.getStudentById(id);
        return Response.ok(student).build();
    }

    @POST
    public Response addStudent(Student student) {
        studentService.addStudent(student);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateStudent(@PathParam("id") int id, Student student) {
        studentService.updateStudent(id, student);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteStudent(@PathParam("id") int id) {
        studentService.deleteStudent(id);
        return Response.noContent().build();
    }
}
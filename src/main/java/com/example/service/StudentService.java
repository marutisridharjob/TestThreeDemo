package com.example.service;

import com.example.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService {

    private List<Student> students = new ArrayList<>();

    public StudentService() {
        // Add dummy data
        Student s1 = new Student("John", "Doe", 20, "1234 Main St", "Springfield", "IL", "62704");
        Student s2 = new Student("Jane", "Smith", 22, "5678 Oak St", "Chicago", "IL", "60616");
        students.add(s1);
        students.add(s2);
    }

    public List<Student> getStudents(String firstName, String lastName, String city) {
        return students.stream()
                .filter(s -> (firstName == null || s.getFirstName().equals(firstName)) &&
                             (lastName == null || s.getLastName().equals(lastName)) &&
                             (city == null || s.getCity().equals(city)))
                .collect(Collectors.toList());
    }

    public Student getStudentById(int id) {
        return students.get(id);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void updateStudent(int id, Student student) {
        students.set(id, student);
    }

    public void deleteStudent(int id) {
        students.remove(id);
    }
}
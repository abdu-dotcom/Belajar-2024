package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // http://localhost:8081/student
    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(
                1, "Ramesh", "Budiman"
        );
        return student;
    }

    // http://localhost:8081/students
    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();

        students.add(new Student(1,"Ramesh","Fadatare"));
        students.add(new Student(2,"umesh","Fadatare"));
        students.add(new Student(3,"Ram","Jadhav"));
        students.add(new Student(4,"Sanjay","Pawar"));
        return students;
    }
}

package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    // Spring BOOT REST API with Path Variable
    // {id} - URI template variable
    // http://localhost:8080/students/{id}

    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        return new Student(studentId, firstName, lastName);
    }

    // Spring BOOT REST API with Path Parameter
    // http://localhost:8080/students/query?id=1&firstName=Ramesh&lastName=Fadatare

    @GetMapping("students/query")
    public Student studentPathParameter(@RequestParam("id") int studentId,
                                        @RequestParam String firstName,
                                        @RequestParam String lastName){
        return new Student(studentId,firstName,lastName);
    }

    // Spring BOOT REST API with Request Body
    // http://localhost:8080/student/create
    // Request Body Json

    @PostMapping("student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return student;
    }

    // Spring boot REST API that handles HTTP PUT Request - updating existing resource
    // http://localhost:8080/student/{id}/update

    @PutMapping("student/{id}/update")
    public Student updateStudent(@RequestBody Student student,@PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    // Spring boot RST API that handles HTTP DELETE Request - deleting existing resource
    // http://localhost:8080/student/{id}/delete

    @DeleteMapping("student/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return "Student deleted successfully";
    }
}
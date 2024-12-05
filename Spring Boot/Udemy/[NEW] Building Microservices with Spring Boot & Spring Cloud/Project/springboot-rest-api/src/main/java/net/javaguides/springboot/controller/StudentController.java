package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // http://localhost:8081/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(
                1, "Ramesh", "Budiman"
        );
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // http://localhost:8081/students
    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();

        students.add(new Student(1,"Ramesh","Fadatare"));
        students.add(new Student(2,"umesh","Fadatare"));
        students.add(new Student(3,"Ram","Jadhav"));
        students.add(new Student(4,"Sanjay","Pawar"));

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // Spring BOOT REST API with Path Variable
    // {id} - URI template variable
    // http://localhost:8080/students/{id}

    @GetMapping("students/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){

        Student student = new Student(studentId, firstName, lastName);

        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    // Spring BOOT REST API with Path Parameter
    // http://localhost:8080/students/query?id=1&firstName=Ramesh&lastName=Fadatare

    @GetMapping("students/query")
    public ResponseEntity<Student> studentPathParameter(@RequestParam("id") int studentId,
                                        @RequestParam String firstName,
                                        @RequestParam String lastName){

        Student student = new Student(studentId, firstName, lastName);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // Spring BOOT REST API with Request Body
    // http://localhost:8080/student/create
    // Request Body Json

    @PostMapping("student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // Spring boot REST API that handles HTTP PUT Request - updating existing resource
    // http://localhost:8080/student/{id}/update

    @PutMapping("student/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());


        return ResponseEntity.ok(student);
    }

    // Spring boot RST API that handles HTTP DELETE Request - deleting existing resource
    // http://localhost:8080/student/{id}/delete

    @DeleteMapping("student/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);

        return ResponseEntity.ok("Student deleted successfully");
    }
}
package com.mongotest.mongodbtestproject.controller;

import com.mongotest.mongodbtestproject.service.StudentService;
import com.mongotest.mongodbtestproject.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent (@RequestBody Student student){
        Student savedStudent = studentService.createStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/searchByFullName")
    public ResponseEntity<List<Student>> getStudentByName (@RequestParam String firstName, @RequestParam String lastName){
        List<Student> findStudents = studentService.getStudentByName(firstName, lastName);
        return ResponseEntity.ok(findStudents);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents (){
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PutMapping("{studentId}")
    public ResponseEntity<Student> updateStudent (@PathVariable("studentId") String id, @RequestBody Student updatedStudent){
        Student student = studentService.updateStudent(id, updatedStudent);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("{studentId}")
    public ResponseEntity<String> deleteStudent (@PathVariable("studentId") String id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Delete Successfully");
    }

}

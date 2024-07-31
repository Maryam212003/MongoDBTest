package com.mongotest.mongodbtestproject.controller;

import com.mongotest.mongodbtestproject.dto.StudentDTO;
import com.mongotest.mongodbtestproject.service.StudentService;
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
    public ResponseEntity<StudentDTO> createStudent (@RequestBody StudentDTO studentDTO){
        StudentDTO savedStudent = studentService.createStudent(studentDTO);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/searchByFullName")
    public ResponseEntity<List<StudentDTO>> getStudentByName (@RequestParam String firstName, @RequestParam String lastName){
        List<StudentDTO> findStudents = studentService.getStudentByName(firstName, lastName);
        return ResponseEntity.ok(findStudents);
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents (){
        List<StudentDTO> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PutMapping("{studentId}")
    public ResponseEntity<StudentDTO> updateStudent (@PathVariable("studentId") String id, @RequestBody StudentDTO updatedStudent){
        StudentDTO student = studentService.updateStudent(id, updatedStudent);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("{studentId}")
    public ResponseEntity<String> deleteStudent (@PathVariable("studentId") String id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Delete Successfully");
    }

}

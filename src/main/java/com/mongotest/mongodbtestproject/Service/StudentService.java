package com.mongotest.mongodbtestproject.Service;

import com.mongotest.mongodbtestproject.model.Student;
import com.mongotest.mongodbtestproject.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent (Student student){
        return studentRepository.save(student);
    }

    public List<Student> getStudentByName (String firstName, String lastName){
        return studentRepository.findStudentByName(firstName, lastName);
    }

    public List<Student> getAllStudents (){
        return studentRepository.findAll();
    }

    public Student updateStudent (String id, Student updatedStudent){
        updatedStudent.setId(id);
        Student student = studentRepository.save(updatedStudent);
        return student;
    }
    public void deleteStudent (String id){
        studentRepository.deleteById(id);
    }

}

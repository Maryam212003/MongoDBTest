package com.mongotest.mongodbtestproject.service;

import com.mongotest.mongodbtestproject.dto.StudentDTO;
import com.mongotest.mongodbtestproject.mapper.StudentMapper;
import com.mongotest.mongodbtestproject.model.Student;
import com.mongotest.mongodbtestproject.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentDTO createStudent (StudentDTO studentDTO){
        Student student = studentMapper.mapperToStudent(studentDTO);
        return studentMapper.mapperToStudentDTO(studentRepository.save(student));
    }

    public List<StudentDTO> getStudentByName (String firstName, String lastName){
        List<Student> foundStudents = studentRepository.findStudentByName(firstName, lastName);
        return foundStudents.stream().map(studentMapper::mapperToStudentDTO).collect(Collectors.toList());
    }

    public List<StudentDTO> getAllStudents (){
        List<Student> students = studentRepository.findAll();
        return students.stream().map(studentMapper::mapperToStudentDTO).collect(Collectors.toList());
    }

    public StudentDTO updateStudent (String id, StudentDTO updatedStudentDTO){
        Student student = studentRepository.findById(id).orElseThrow(RuntimeException::new);
        student.update(studentMapper.mapperToStudent(updatedStudentDTO));
        Student updatedStudent = studentRepository.save(student);
        return studentMapper.mapperToStudentDTO(updatedStudent);
    }
    public void deleteStudent (String id){
        studentRepository.deleteById(id);
    }

}

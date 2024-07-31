package com.mongotest.mongodbtestproject.mapper;

import com.mongotest.mongodbtestproject.dto.StudentDTO;
import com.mongotest.mongodbtestproject.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDTO mapperToStudentDTO(Student student);

    @Mapping(target = "id", ignore = true)
    Student mapperToStudent(StudentDTO studentDTO);
}

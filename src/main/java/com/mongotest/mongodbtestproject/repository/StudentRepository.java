package com.mongotest.mongodbtestproject.repository;

import com.mongotest.mongodbtestproject.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, String> {

    @Query(value = "{ 'first_name': :#{#firstName}, 'last_name': :#{#lastName} }")
    List<Student> findStudentByName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}

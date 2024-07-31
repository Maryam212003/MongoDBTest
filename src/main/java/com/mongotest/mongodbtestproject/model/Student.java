package com.mongotest.mongodbtestproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "students")
public class Student {
    @Id
    private String id;

    @Field(name = "first_name")
    private String firstName;

    @Field(name = "last_name")
    @Indexed
    private String lastName;

    @Field(name = "field_of_study")
    private FieldOfStudy fieldOfStudy;

    @Indexed(unique = true)
    @Field(name = "personal_id")
    private String personalId;

    public Student(String firstName, String lastName, FieldOfStudy fieldOfStudy, String personalId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fieldOfStudy = fieldOfStudy;
        this.personalId = personalId;
    }
}

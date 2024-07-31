package com.mongotest.mongodbtestproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@AllArgsConstructor
@NoArgsConstructor
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public FieldOfStudy getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(FieldOfStudy fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public void update(Student updatedStudent) {
        this.firstName = updatedStudent.getFirstName();
        this.lastName = updatedStudent.getLastName();
        this.personalId = updatedStudent.getPersonalId();
        this.fieldOfStudy = updatedStudent.getFieldOfStudy();
    }
}

##  README for MongoDBTest Project

This project demonstrates using MongoDB with Spring Data and MapStruct in a Java Spring Boot application. It serves as a learning resource for developers interested in these technologies.

###  Features

* Connects to a MongoDB database
* Defines a `Student` entity representing student data
* Uses Spring Data to interact with the MongoDB database
* Implements a `StudentDTO` to transfer student data without including the ID field
* Utilizes MapStruct to map between `Student` and `StudentDTO` objects

###  Getting Started

**Prerequisites:**

* Java 17+
* Maven build tool
* MongoDB server running locally or remotely

**Steps:**

1. Clone the repository:

```
git clone https://github.com/Maryam212003/MongoDBTest.git
```

2. Navigate to the project directory:

```
cd MongoDBTest
```

3. Install dependencies:

```
mvn install
```

4. Configure your MongoDB connection details (optional):

   Edit `src/main/resources/application.properties` and update the `spring.data.mongodb.uri` property with your MongoDB connection string. If no configuration is provided, the application attempts to connect to the default local MongoDB instance.

5. Run the application:

```
mvn spring-boot:run
```

**Access Swagger UI:**

Navigate to ([Swagger UI](http://localhost:8080/swagger-ui.html)) to access the Swagger UI for detailed API documentation and testing.

###  Project Structure

```
src/main/java/    - Java source code for the project
    com/mongotest/  - Main package containing project code
        mongodbtestproject/
            model/     - Domain entities (e.g., Student)
            dto/       - Data Transfer Objects (DTOs) (e.g., StudentDTO)
            mapper/    - MapStruct mapper interface for object mapping
            service/    - Service layer for business logic
            controller/ - (Not included in this project) Controller layer for handling requests and responses
            repository/ - Spring Data repository for interacting with MongoDB
            application.properties - Application properties file
src/test/java/     - Unit tests for the application
pom.xml            - Maven project configuration file
README.md          - This file (documentation)
```

###  Using the Code

* The `Student` class represents a student with fields for first name, last name, field of study, and personal ID.
* The `StudentDTO` class mirrors the `Student` class but excludes the ID field for data transfer purposes.
* The `StudentMapper` interface defines mappings between `Student` and `StudentDTO` using MapStruct annotations.
* The `StudentService` class (not included in this basic example) would handle business logic related to student data.
* The `StudentRepository` extends `MongoRepository` from Spring Data MongoDB to interact with the `students` collection in the database.


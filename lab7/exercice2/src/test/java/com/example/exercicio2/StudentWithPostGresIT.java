package com.example.exercicio2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Testcontainers
@SpringBootTest
public class StudentWithPostGresIT {

    @Autowired
    StudentRepository bookRepository;
    // container {
    @Container
    public static PostgreSQLContainer container = new PostgreSQLContainer(DockerImageName.parse("postgres:12"))
            .withUsername("admin")
            .withPassword("admin")
            .withDatabaseName("test");

    // }


    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("spring.datasource.username", container::getUsername);
    }

    @Test
    void whenInsertOneStudent_then_ShouldSucced(){
        Student student = new Student();
        student.setName("Rui Silva");
        student.setAge(19);
        student.setCourse("LEI");
        student.setNmec(100000);
        student.setNationality("Portuguese");
        bookRepository.save(student);

        List<Student> students = bookRepository.findAll();

        assertTrue(student.getName().equals(students.get(0).getName()));

    }



}

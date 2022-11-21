package com.manesh.services;

import com.manesh.entities.Students;
import com.manesh.repositories.StudentsRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
class StudentsServiceTest {

    @Autowired
    @MockBean
    private StudentsRepo studentsRepo;


    @Test
    void saveStudentDetails() {
        Students students = Students.builder()
                .name("Borkar")
                .number(45653L)
                .build();
        studentsRepo.save(students);
        Assertions.assertNotNull(students);
    }

    @Test
    void getStudentsDetails() {
        List<Students> studentsList = studentsRepo.findAll();
        Assertions.assertNotNull(studentsList);
    }

    @Test
    void deleteStudentDetails() {
    }

    @Test
    void updateStudentDetails() {
    }
}
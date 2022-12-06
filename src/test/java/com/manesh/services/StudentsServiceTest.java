package com.manesh.services;

import com.manesh.entities.Students;
import com.manesh.repositories.StudentsRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;


@SpringBootTest
class StudentsServiceTest {

    @InjectMocks
    StudentsService studentsService;

    @Mock
    StudentsRepo studentsRepo;


    @Test
    void test_getStudents(){
        List<Students> studentsList = new ArrayList<Students>();
        Students student1 = Students.builder().id(1).name("Borkar").number(45653L).build();
        Students student2 = Students.builder().id(2).name("manesh").number(12345L).build();
        studentsList.add(student1);
        studentsList.add(student2);
        when(studentsRepo.findAll()).thenReturn(studentsList);

        Assertions.assertEquals(2,studentsService.getStudents().size());
    }

    @Test
    void test_getStudentById(){
        List<Students> studentsList = new ArrayList<Students>();
        Students student1 = Students.builder().id(1).name("Borkar").number(45653L).build();
        Students student2 = Students.builder().id(2).name("manesh").number(12345L).build();
        studentsList.add(student1);
        studentsList.add(student2);
        when(studentsRepo.findById(1)).thenReturn(Optional.ofNullable(studentsList.get(0)));

        Assertions.assertEquals(1,studentsService.getStudentById(1).getId());

    }

    @Test
    void test_deleteStudentById(){
        List<Students> studentsList = new ArrayList<>();
        Students student1 = Students.builder().id(1).name("Borkar").number(45653L).build();
        Students student2 = Students.builder().id(2).name("manesh").number(12345L).build();
        studentsList.add(student1);
        studentsList.add(student2);
        when(studentsRepo.findById(1)).thenReturn(Optional.ofNullable(studentsList.get(0)));
        studentsService.delete(1);
        verify(studentsRepo,times(1)).delete(student1);

    }

    @Test
    void test_addStudent(){
        Students student3 = Students.builder().id(3).name("MANGYA").number(9292953L).build();
        when(studentsRepo.save(student3)).thenReturn(student3);
        Assertions.assertEquals(student3,studentsService.saveStudent(student3));
    }

    @Test
    void test_updateStudent(){
        List<Students> studentsList = new ArrayList<Students>();
        Students student1 = Students.builder().id(1).name("Borkar").number(45653L).build();
        Students updatedStudent = Students.builder().id(1).name("manesh").number(12345L).build();
        studentsList.add(student1);
        when(studentsRepo.save(student1)).thenReturn(updatedStudent);
        Assertions.assertEquals(updatedStudent,studentsService.saveStudent(student1));
    }
}
package com.manesh.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manesh.entities.Students;
import com.manesh.services.StudentsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest
class StudentsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    StudentsController studentsController;

    @Mock
    StudentsService studentsService;

    @BeforeEach
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(studentsController).build();
    }

    @Test
    void test_getAllStudents() throws Exception {
        List<Students> studentsList = new ArrayList<>();
        Students student1 = Students.builder().id(1).name("Borkar").number(45653L).build();
        Students student2 = Students.builder().id(2).name("manesh").number(12345L).build();
        studentsList.add(student1);
        studentsList.add(student2);

        when(studentsService.getStudents()).thenReturn(studentsList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/students"))
                .andExpect(status().isOk())
//                .andDo(print())
        ;
    }

    @Test
    void test_getStudentById() throws Exception {
        List<Students> studentsList = new ArrayList<>();
        Students student1 = Students.builder().id(1).name("Borkar").number(45653L).build();
        Students student2 = Students.builder().id(2).name("manesh").number(12345L).build();
        studentsList.add(student1);
        studentsList.add(student2);

        when(studentsService.getStudentById(anyInt())).thenReturn(student1);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/student/{id}",1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Borkar"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.number").value(45653L))
                .andExpect(status().isOk())
//                .andDo(print())
        ;
    }

    @Test
    void test_addStudents() throws Exception {
        Students student1 = Students.builder().id(1).name("Borkar").number(45653L).build();

        when(studentsService.saveStudent(any(Students.class))).thenReturn(student1);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/add")
                        .content(new ObjectMapper().writeValueAsString(student1))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Borkar"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.number").value(45653L))
//                .andDo(print())
        ;
    }

    @Test
    void test_deleteStudent() throws Exception {
        List<Students> studentsList = new ArrayList<>();
        Students student1 = Students.builder().id(1).name("Borkar").number(45653L).build();
        Students student2 = Students.builder().id(2).name("manesh").number(12345L).build();
        studentsList.add(student1);
        studentsList.add(student2);

        when(studentsService.getStudentById(anyInt())).thenReturn(student1);

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/remove/{id}",1))
                .andExpect(status().isNoContent())
        ;

    }

    @Test
    void test_updateStudentDetails() throws Exception {
        Students student1 = Students.builder().id(1).name("Borkar").number(45653L).build();
        Students updateStudent = Students.builder().id(1).name("manesh").number(12345L).build();

        when(studentsService.getStudentById(anyInt())).thenReturn(student1);
        when(studentsService.update(1,updateStudent)).thenReturn(updateStudent);

        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/update/{id}",1)
                        .content(new ObjectMapper().writeValueAsString(updateStudent))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("manesh"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.number").value(12345L))
                .andExpect(status().isOk());
    }

}
package com.manesh.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.manesh.entities.Students;
import com.manesh.repositories.StudentsRepo;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(MockitoJUnitRunner.class)
class StudentsControllerTest {

    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private StudentsRepo studentsRepo;

    @InjectMocks
    private StudentsController studentsController;

    Students student1 = Students.builder()
            .id(1)
            .name("Borkar")
            .number(45653L)
            .build();
    Students student2 = Students.builder()
            .id(2)
            .name("manesh")
            .number(12345L)
            .build();

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(studentsController).build();
    }

    @Test
    public void getStudents_success() throws Exception {
        List<Students> studentsList = new ArrayList<>(Arrays.asList(student1,student2));
        Mockito.when(studentsRepo.findAll()).thenReturn(studentsList);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                .get("/students")
//                .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void addStudents_success() throws Exception {
        Students student3 = Students.builder()
                .id(3)
                .name("abcd")
                .number(98776554L)
                .build();
        Mockito.when(studentsRepo.save(student3)).thenReturn(student3);

        String content = objectWriter.writeValueAsString(student3);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/add")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);
//
//        mockMvc.perform(mockRequest)
////                .andExpect(status().isOk())
//                .andExpect(jsonPath("$",notNullValue()))
//                .andExpect(jsonPath("$.id",is(3)));
    }
}
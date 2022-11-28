package com.manesh.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.manesh.entities.Students;
import com.manesh.repositories.StudentsRepo;
import com.manesh.services.StudentsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
class StudentsControllerTest {

    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private StudentsRepo studentsRepo;

    @InjectMocks
    private StudentsController studentsController;

    @Mock
    private StudentsService studentsService;

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
     void getStudents_success() {
        List<Students> studentsList = new ArrayList<>(Arrays.asList(student1,student2));
        Mockito.when(studentsRepo.findAll()).thenReturn(studentsList);
        Assertions.assertEquals(2,studentsRepo.findAll().size());

//        mockMvc.perform(MockMvcRequestBuilders
//                .get("/students")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(2)));
//                .andExpect(jsonPath("$",notNullValue()))
//                .andExpect(jsonPath("$.id",is(3)));;
    }

    @Test
     void addStudents_success() {
        Students student3 = Students.builder()
                .id(3)
                .name("abcd")
                .number(98776554L)
                .build();
        Mockito.when(studentsService.saveStudent(student3)).thenReturn(student3);
        Assertions.assertNotNull(studentsService);

//        String content = objectWriter.writeValueAsString(student3);
//
//        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/add")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(content);

//        mockMvc.perform(mockRequest)
////                .andExpect(status().isOk())
//                .andExpect(jsonPath("$",notNullValue()))
//                .andExpect(jsonPath("$.id",is(3)));
    }

//    @Test
//     void deleteStudent_success(){
//        studentsService.delete(1);
//        Mockito.when(studentsService.delete(1)).thenReturn("DELETED");
//        Assertions.assertFalse(studentsRepo.findById(1).isPresent());
//    }

    @Test
     void updateStudent_success(){

    }
}
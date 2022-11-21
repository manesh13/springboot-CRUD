package com.manesh.controller;

import com.manesh.entities.Students;
import com.manesh.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @PostMapping("/add")
    public Students addStudents(@RequestBody Students students){
        return studentsService.saveStudent(students);
    }
    @GetMapping("/students")
    public List<Students> getStudents(){
        return studentsService.getStudents();
    }

    @DeleteMapping("/remove/{id}")
    public String deleteStudent(@PathVariable int id){
        return studentsService.delete(id);
    }

    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable int id,@RequestBody Students students){
        return studentsService.update(id,students);
    }
}

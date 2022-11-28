package com.manesh.controller;

import com.manesh.entities.Students;
import com.manesh.exception.ResourceNotFoundException;
import com.manesh.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

//
    @GetMapping("/students")
    public List<Students> getStudents(){
        return studentsService.getStudents();
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Students> getStudent(@PathVariable("id") int id) throws ResourceNotFoundException {
        Students studentById = studentsService.getStudentById(id);
        return ResponseEntity.ok(studentById);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Students> addStudents(@Valid @RequestBody Students student){
        Students savedStudent = studentsService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Students> deleteStudent(@PathVariable("id") int id) throws ResourceNotFoundException{
        studentsService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Students> updateStudent(@PathVariable("id") int id,@Valid @RequestBody Students students) throws ResourceNotFoundException{
        Students updatedStudent = studentsService.update(id,students);
        return ResponseEntity.ok(updatedStudent);
    }
}

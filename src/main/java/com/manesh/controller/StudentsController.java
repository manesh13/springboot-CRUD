package com.manesh.controller;

import com.manesh.entities.Students;
import com.manesh.services.StudentsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @ApiOperation(value = "View a list of available products", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )

    @PostMapping("/add")
    public Students addStudents(@RequestBody Students students){
        return studentsService.saveStudent(students);
//        code 201
    }
    @GetMapping("/students")
    public List<Students> getStudents(){
        return studentsService.getStudents();
    }

    @DeleteMapping("/remove/{id}")
    public String deleteStudent(@PathVariable int id){
        return studentsService.delete(id);
//        return custom status code with a custom mesg
    }

    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable int id,@RequestBody Students students){
        return studentsService.update(id,students);
    }
}

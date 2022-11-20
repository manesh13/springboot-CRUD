package com.manesh.services;

import com.manesh.entities.Students;
import com.manesh.repositories.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {

    @Autowired
    private StudentsRepo studentsRepo;

    public Students saveStudent(Students students){
        return studentsRepo.save(students);
    }

    public List<Students> getStudents(){
        return studentsRepo.findAll();
    }

    public void deleteStudent(Integer id) {
        studentsRepo.deleteById(id);
    }

}

package com.manesh.services;

import com.manesh.entities.Students;
import com.manesh.exception.ResourceNotFoundException;
import com.manesh.repositories.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {

    @Autowired
    private StudentsRepo studentsRepo;

    public StudentsService(StudentsRepo studentsRepo) {
        this.studentsRepo = studentsRepo;
    }

    public Students saveStudent(Students students) {
        return studentsRepo.save(students);
    }

    public List<Students> getStudents() {
        return studentsRepo.findAll();
    }

    public String delete(int id) {
        if (studentsRepo.findById(id).isPresent()) {
            studentsRepo.deleteById(id);
            return "STUDENT DELETED WITH ID " + id;
        } else
            throw new ResourceNotFoundException("NO STUDENT PRESET WITH ID" + id);
    }

    public String update(int id, Students students) {
        if (studentsRepo.findById(id).isPresent()) {
            Students studentUpdate = studentsRepo.findById(id).get();
            studentUpdate.setName(students.getName());
            studentUpdate.setNumber(students.getNumber());
            studentsRepo.save(studentUpdate);
            return "UPDATED";
        } else
            throw new ResourceNotFoundException("NO STUDENT PRESET WITH ID" + id);
    }
}

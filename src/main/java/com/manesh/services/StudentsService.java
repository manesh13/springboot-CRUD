package com.manesh.services;

import com.manesh.entities.Students;
import com.manesh.exception.ResourceNotFoundException;
import com.manesh.repositories.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsService {

    private String error = "Student not found with id ";
    @Autowired
    private StudentsRepo studentsRepo;

    public StudentsService(StudentsRepo studentsRepo) {
        this.studentsRepo = studentsRepo;
    }

    public Students saveStudent(Students student) {
        return studentsRepo.save(student);
    }

    public List<Students> getStudents() {
        return studentsRepo.findAll();
    }

    public Students getStudentById(int id) throws ResourceNotFoundException {
        Optional<Students> findById = studentsRepo.findById(id);
        if (!findById.isPresent()) {
            throw new ResourceNotFoundException(error + id );
        }
        return findById.get();
    }

    public void delete(int id) throws ResourceNotFoundException{
        Optional<Students> findById = studentsRepo.findById(id);
        Students student = findById
                .orElseThrow(() -> new ResourceNotFoundException(error + id ));

        studentsRepo.delete(student);
    }

    public Students  update(int id, Students student) throws ResourceNotFoundException {
        Optional<Students> findById = studentsRepo.findById(id);

        if (!findById.isPresent()) {
            throw new ResourceNotFoundException(error + id );
        }
        Students studentUpdate = studentsRepo.findById(id).get();
        studentUpdate.setName(student.getName());
        studentUpdate.setNumber(student.getNumber());
        return studentsRepo.save(studentUpdate);
    }
}

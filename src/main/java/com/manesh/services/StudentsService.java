package com.manesh.services;

import com.manesh.repositories.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentsService {

    @Autowired
    private StudentsRepo studentsRepo;


}

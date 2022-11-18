package com.manesh.repositories;

import com.manesh.entities.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepo extends JpaRepository<Students, Integer> {
}
